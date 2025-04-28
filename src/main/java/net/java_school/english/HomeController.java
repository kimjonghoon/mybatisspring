package net.java_school.english;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@Autowired
	private WordCardService wordCardService;

	@GetMapping("/")
	public String homepage(Model model) {
		WordCard wordCard = wordCardService.getWordCard();
		model.addAttribute("wordCard", wordCard);
		return "index";
	}
	
	@PostMapping("/")
	public String addWord(@RequestParam(name="word") String word, @RequestParam(name="definitions") String definitions) {
		wordCardService.add(word, definitions);
		return "redirect:/";
	}
}
