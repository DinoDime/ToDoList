package co.grandcircus.capstone6;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private TaskRepo taskRepo;
	@Autowired
	private HttpSession session;
	
	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}
	
	@PostMapping("/login")
	public String login(Users user, Model model) {
		Users newUser = userRepo.findByEmail(user.getEmail()); 
		if (newUser != null && newUser.getPassword().compareTo(user.getPassword()) == 0) {
			session.setAttribute("email", newUser.getEmail());
			session.setAttribute("userid", newUser.getId());
			return "redirect:/tasks";
		}
		else {
			model.addAttribute("We have encounterd an error. Please try again.");
			return "index";
		}
	}
	@GetMapping("/logout")
	public String logout( ) {
		return "redirect:/";
	}
	@SuppressWarnings("unchecked")
	@PostMapping("/signup")
	public String signUp(Users user, Model model) {
		if(!user) {
			return "redirect:/login";
		} else{
			((CrudRepository<Users, Long>) user).save(user);
			return "redirect:/tasks/" + user.getId();
		}
	}
	@GetMapping("/currenttasks")
	public String todos(Model model) {
		String email = (String) session.getAttribute("email");
		Users user = userRepo.findByEmail(email);
		model.addAttribute("user", user);
		return "tasks";
	}
	
	@PostMapping("/addatask")
	public String save(Tasks task, Model model) {
		String email = (String)session.getAttribute("email");
		if (!email) {
			return "redirect:/";
		}
		Users newUser = userRepo.findByEmail(email);
		task.setUser(newUser);
		taskRepo.save(task);
		return "redirect:/tasks";
	}
}
