package net.codejava.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.dao.PortfolioRepository;
import net.codejava.domain.Portfolio;
import net.codejava.service.PortfolioService;

@Controller
public class PortfolioController {
	
	@Autowired
	private PortfolioService portfolioService;

	
	@RequestMapping(value = "/")
	public String getAllPortfolios(Model model) {
		model.addAttribute("portfolios", portfolioService.getAllPortfolios());
		return "Portfolio";
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String addNewPortfolio(@ModelAttribute("newPortfolio") Portfolio portfolio) {
		portfolioService.addPortfolio(portfolio);
		return "redirect:/";
	}
	
	//below methods are used to add new product to the store, moreover, it used form backing bean in order to get information
	//from the HTML form elements in order to process them in the Controller
	@RequestMapping(value = "/addPortfolio", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model) {
		Portfolio newPortfolio = new Portfolio();
		model.addAttribute("newPortfolio", newPortfolio);
		return "addPortfolio";
	}
	
	//-----------------------------------------------------------------------------------------------------------------
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateAndsave(@ModelAttribute("portfolio") Portfolio p) {
		portfolioService.update(p);
		return "redirect:/";
	}
	
	
	@RequestMapping(value = "/edit")
	public ModelAndView getPortfolioById(@RequestParam("id") int portfolioId) {
		ModelAndView model = new ModelAndView("editPortfolio");
		Portfolio p = portfolioService.getPortfolioById(portfolioId);
		model.addObject("portfolio", p);
		return model;
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String deletePortfolio(@RequestParam long id) {
		portfolioService.delete(id);
		return "redirect:/";
		
	}
	
	
	
	//InitializeBinder method used to set up fields which allowed for binding submission
	@InitBinder("newPortfolio")
	public void intializeBinder(WebDataBinder binder) {
		binder.setAllowedFields("name",
				"unitPrice",
				"share");
	}
	
	
	
	
}
