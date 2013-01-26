package wyd.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import wyd.dto.User;
import wyd.dto.WebMessage;
import wyd.service.AcmService;
import wyd.service.InvalidCredentialException;

@Controller
public class WydController extends AbstractController {

	@Autowired
	@Qualifier("memoryAcmService")
	private AcmService acmService;

	@RequestMapping("/")
	public ModelAndView home() {
		return this.index();
	}

	@RequestMapping("/wydIndex.java")
	public ModelAndView index() {
		ModelAndView mav = this.createDefaultModelAndView("wydIndex", "Home");

		return mav;
	}

	@RequestMapping("/wydLogin.java")
	public ModelAndView login() {
		ModelAndView mav = this
				.createDefaultModelAndView("wydLogin", "Sign In");

		return mav;
	}

	@RequestMapping("/wydAuthenticate.java")
	public String authenticate(
			@RequestParam("userId") String userId,
			@RequestParam("password") String password,
			@RequestParam(value = "callbackUrl", required = false) String callbackUrl,
			HttpSession session) {
		String rstring = null;
		try {
			User user = acmService.authenticate(userId, password);
			session.setAttribute("user", user);

			if (callbackUrl != null) {
				rstring = "redirect:" + callbackUrl;
			} else {
				rstring = "redirect:wydIndex.java";
			}

		} catch (InvalidCredentialException ice) {
			WebMessage webMessage = WebMessage.createErrorMessage(ice
					.getMessage());
			rstring = "redirect:wydLogin.java?" + webMessage.toQueryString();
		}

		return rstring;
	}

	@RequestMapping("/wydLogout.java")
	public ModelAndView logout(HttpSession session) {

		session.removeAttribute("user");
		ModelAndView mav = this.index();

		return mav;
	}

	@RequestMapping("/wydAbout.java")
	public ModelAndView about() {
		ModelAndView mav = this.createDefaultModelAndView("wydAbout", "About");

		return mav;
	}

	@RequestMapping("/t/ping.java")
	public @ResponseBody
	String ping() {
		return "ping pong!";
	}

}
