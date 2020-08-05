package emg.springframework.sfgpetclinic.controllers;

import emg.springframework.sfgpetclinic.model.Owner;
import emg.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@RequestMapping("/owners")
@Controller
public class OwnerController {

	private final OwnerService ownerService;

	@Autowired
	public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}

	@RequestMapping( {"", "/", "/index", "/index.html"})
	public String listOwner(Model model) {
		Set<Owner> owners = ownerService.findAll();
		model.addAttribute("owners", owners);
		return "owners/index";
	}

}
