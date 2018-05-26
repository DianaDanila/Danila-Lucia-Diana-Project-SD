package communication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/doctor")//pagina de doctor
public class DoctorController {

//	@Autowired
//	private DoctorBLL dbll;
	
	@GetMapping
    public ModelAndView s() {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("doctor");
        return modelAndView;
    }
	
//	//@RequestMapping(method = RequestMethod.GET)
//	@GetMapping("/{id}")
//	public Doctor getById(@PathVariable ("id")int id) {
//		return dbll.getById(id);
//	}
//	
//	@GetMapping("/doctors")
//	public Iterable<Doctor> getDoctors() {
//		return dbll.findAll();
//	}
	
//	@GetMapping("/login")
//	public boolean login() {
//		return dbll.login(name, pass);
//	}

}
