package wyd.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import wyd.dto.WebMessage;

public class GenericSpringInterceptor extends HandlerInterceptorAdapter {

	final Logger _log = LoggerFactory.getLogger(GenericSpringInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res,
			Object handler) throws Exception {
		WebMessage webMessage = WebMessage.createMessage(req);
		if (webMessage != null) {
			req.setAttribute("webMessage", webMessage);
			if (_log.isDebugEnabled()) {
				_log.debug("WebMessage = {}", webMessage.toQueryString());
			}
		}

		String callbackUri = req.getParameter("callbackUrl");
		if (callbackUri != null) {
			req.setAttribute("callbackUrl", callbackUri);
			if (_log.isDebugEnabled()) {
				_log.debug("Callback URI = {}", callbackUri);
			}
		}

		HttpSession session = req.getSession(true);

		return super.preHandle(req, res, handler);
	}
}
