package in.sasi.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.sasi.service.GeneralApiService;

@Controller
public class HomePageController {

	@Autowired
	private GeneralApiService generalApiService;
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("appServerTime", formattedDate);
		model.addAttribute("platformPing", generalApiService.ping());
		//model.addAttribute("platformTime", generalApiService.getServerTime());
		return "dashboard";
	}

}
