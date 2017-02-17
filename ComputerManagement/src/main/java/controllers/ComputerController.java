package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domain.Computer;
import services.ComputerService;

@Controller
public class ComputerController {
	private ComputerService computerService;
	
	@Autowired(required=true)
	@Qualifier(value="computerService")
	public void setComputerService(ComputerService ps){
		this.computerService = ps;
	}
	
	@RequestMapping(value = "/computers", method = RequestMethod.GET)
	public String listComputers(Model model) {
		model.addAttribute("computer", new Computer());
		model.addAttribute("listComputers", this.computerService.getComputers());
		return "computer";
	}
	
	//For add and update computer both
	@RequestMapping(value= "/computer/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("computer") Computer c){
		
		if(c.getId() == 0){
			//new computer, add it
			this.computerService.addComputer(c);
		}else{
			//existing computer, call update
			this.computerService.updateComputer(c);
		}
		
		return "redirect:/computers";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
		
        this.computerService.removeComputer(id);
        return "redirect:/computers";
    }
 
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("computer", this.computerService.getComputerById(id));
        model.addAttribute("listComputers", this.computerService.getComputers());
        return "computer";
    }
	
	
}
