package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Fudge;
import dmacc.repository.FudgeRepository;

/**
 * @author chumb - djackson16 CIS175 - Spring 2024 Apr 2, 2024
 */

@Controller
public class WebController {
	@Autowired
	FudgeRepository repo;

	@GetMapping("/viewAll")
	public String viewAllFudge(Model model) {
		if (repo.findAll().isEmpty()) {
			return addNewFudge(model);
		}
		model.addAttribute("fudge", repo.findAll());
		return "results";
	}

	@GetMapping("/inputFudge")
	public String addNewFudge(Model model) {
		Fudge f = new Fudge();
		model.addAttribute("newFudge", f);
		return "input";
	}

	@PostMapping("/inputFudge")
	public String addNewFudge(@ModelAttribute Fudge f, Model model) {
		repo.save(f);
		return viewAllFudge(model);
	}

	@GetMapping("/edit/{id}")
	public String showUpdateFudge(@PathVariable("id") long id, Model model) {
		Fudge f = repo.findById(id).orElse(null);
		model.addAttribute("newFudge", f);
		return "input";
	}

	@PostMapping("/update/{id}")
	public String reviseFudge(Fudge c, Model model) {
		repo.save(c);
		return viewAllFudge(model);
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Fudge f = repo.findById(id).orElse(null);
		repo.delete(f);
		return viewAllFudge(model);
	}
}
