package emg.springframework.sfgpetclinic.controllers;

import emg.springframework.sfgpetclinic.model.Vet;
import emg.springframework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
public class VetController {

	private final VetService vetService;

	@Autowired
	public VetController(VetService vetService) {
		this.vetService = vetService;
	}

	@RequestMapping({ "/vets", "/vets/index", "/vets/index.html", "/vets.html" })
	public String listVets(Model model) {
		Set<Vet> vets = vetService.findAll();
		model.addAttribute("vets", vets);
		return "vets/index";
	}

}
