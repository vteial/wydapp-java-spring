package wyd.web;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.ModelAndView;

public abstract class AbstractController {

	@Autowired
	ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@Autowired
	ServletContext servletContext;

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	protected ModelAndView createDefaultModelAndView() {
		ModelAndView mav = new ModelAndView("wydLayout");
		return mav;
	}

	protected ModelAndView createDefaultModelAndView(String viewName,
			String viewTitle) {
		ModelAndView mav = this.createDefaultModelAndView();
		mav.addObject("viewName", viewName);
		mav.addObject("viewTitle", viewTitle);
		return mav;
	}
}
