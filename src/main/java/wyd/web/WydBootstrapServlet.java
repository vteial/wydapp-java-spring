package wyd.web;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WydBootstrapServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	final Logger _log = LoggerFactory.getLogger(WydBootstrapServlet.class);

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		_log.info("################################################");
		_log.info("Bootstrap init work starts...");

		ServletContext scontext = this.getServletContext();

		String s = scontext.getRealPath("/bootloader");
		_log.info("realPath : {}", s);
		s = s.substring(0, s.indexOf("bootloader"));
		scontext.setAttribute("webHome", s);
		_log.info("webHome  : {}", scontext.getAttribute("webHome"));

		s = (String) scontext.getAttribute("webHome");
		s += "WEB-INF/classes/application.properties";
		this.loadPropertiesInToServletContext(scontext, new File(s));

		_log.info("Bootstrap init work ends...");
		_log.info("################################################");
	}

	private void loadPropertiesInToServletContext(ServletContext context,
			File propsFile) {
		try {
			Properties props = new Properties();
			props.load(new FileInputStream(propsFile));
			Iterator i = props.keySet().iterator();
			while (i.hasNext()) {
				String key = (String) i.next();
				Object val = props.get(key);
				context.setAttribute(key, val);
			}
		} catch (Throwable t) {
			_log.error("loading application properties failed...", t);
		}
	}
}