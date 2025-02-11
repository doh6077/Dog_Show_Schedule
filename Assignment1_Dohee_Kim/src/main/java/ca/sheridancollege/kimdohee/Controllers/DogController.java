package ca.sheridancollege.kimdohee.Controllers;

import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.kimdohee.Repositories.DogRepository;
import ca.sheridancollege.kimdohee.Repositories.JudgeRepository;
import ca.sheridancollege.kimdohee.Repositories.OwnerRepository;
import ca.sheridancollege.kimdohee.beans.Dog;
import ca.sheridancollege.kimdohee.beans.Judge;
import ca.sheridancollege.kimdohee.beans.Owner;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor  
public class DogController {
	private DogRepository dogRepo;
	private JudgeRepository judRepo;
	private OwnerRepository ownRepo; 
	
	@GetMapping("/")
	public String iAmRoot() {
		return "home.html";
	}
	
	@GetMapping("/addDog")
	public String loadAddDog(Model model) {
		model.addAttribute("dog", new Dog());
		return "addDog.html"; 
		
	}
	@PostMapping("/addDog") 
	public String processAddDog(@ModelAttribute Dog dog) {
		dogRepo.save(dog);
		return "redirect:/addDog"; 
		
	}
	@GetMapping("/addOwner")
	public String loadAddOwner(Model model) {
		model.addAttribute("owner", new Owner());
		return "addOwner.html"; 
		
	}
	@PostMapping("/addOwner") 
	public String processAddOwner(@ModelAttribute Owner owner) {
		ownRepo.save(owner);
		return "redirect:/addOwner"; 
		
	}	
	@GetMapping("/addJudge")
	public String loadAddJudge(Model model) {
		model.addAttribute("judge", new Judge());
		return "addJudge.html"; 
		
	}
	@PostMapping("/addJudge") 
	public String processAddJudge(@ModelAttribute Judge judge) {
		judRepo.save(judge);
		return "redirect:/addJudge"; 
		
	}	
	@GetMapping("/view")
	public String loadView(Model model) {

		model.addAttribute("dogs", dogRepo.findAll());
		model.addAttribute("owners", ownRepo.findAll());
		model.addAttribute("judges", judRepo.findAll());
		return "view.html";
	}
	
	@GetMapping("/viewDog/{id}")
	public String dogPage(@PathVariable long id, Model model) {
		Optional<Dog> dog = dogRepo.findById(id);
		if (dog.isPresent()) {// The game exists
			Dog selectedDog = dog.get(); 
			model.addAttribute("dog", selectedDog);
			return "viewDog.html"; 			
		} else {
			
			return "redirect:/view";
		}
		

	}

	@GetMapping("/viewOwner/{id}")
	public String ownerPage(@PathVariable long id, Model model) {
		Optional<Owner> owner = ownRepo.findById(id);
		if (owner.isPresent()) {// The game exists
			Owner selectedOwner = owner.get(); 
			model.addAttribute("owner", selectedOwner);
			return "viewOwner.html"; 			
		} else {
			
			return "redirect:/view";
		}
		

	}
	@GetMapping("/viewJudge/{id}")
	public String judgePage(@PathVariable long id, Model model) {
		Optional<Judge> judge = judRepo.findById(id);
		if (judge.isPresent()) {// The game exists
			Judge selectedJud = judge.get(); 
			model.addAttribute("judge", selectedJud);
			return "viewJudge.html"; 			
		} else {
			
			return "redirect:/view";
		}
	}
	@DeleteMapping("/deleteJudge/{id}")
	public String deleteJudge(@PathVariable long id, Model model) {
	    judRepo.deleteById(id);
	    return "redirect:/view";
	}
}
