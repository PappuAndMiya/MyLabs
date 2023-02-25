package in.sasi.controller;

import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.sasi.service.GeneralApiService;
import in.sasi.service.PublicApiService;

@Controller
public class HomePageController {

	@Autowired
	private GeneralApiService generalApiService;
	
	@Autowired
	private PublicApiService publicApiService;
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		model.addAttribute("appServerTime", new Date());
		//model.addAttribute("platformPing", generalApiService.ping());
		//model.addAttribute("platformTime", generalApiService.getServerTime());
		//model.addAttribute("platformStatus", generalApiService.getSystemStatus());
		//model.addAttribute("platformInfo", generalApiService.getExchangeInfo());
		
		//model.addAttribute("tickers", publicApiService.getTickers());
		model.addAttribute("tickersByQuoteAsset", publicApiService.getTickersByQuoteAsset("inr"));
		
		return "dashboard";
	}

}
