package communication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import bll.DoctorBLL;
import bll.dto.DoctorDTO;

@RestController
@RequestMapping("/doctor/login")
public class LogInDController {
	
	@Autowired
	private DoctorBLL dbll;

	@GetMapping
    public ModelAndView s() {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("login1");
        return modelAndView;
    }
	
	@PostMapping(consumes = {"multipart/form-data"})
	public ModelAndView login(@RequestPart("user") String name, @RequestPart("password") String pass) {
		if(dbll.login(name, pass)) {
			ModelAndView modelAndView = new ModelAndView();
	    	modelAndView.setViewName("logeddoctor");
	    	List<DoctorDTO> doctorsList = dbll.findAll();
	    	modelAndView.addObject("doctors", doctorsList);
	        return modelAndView;
		}
		else {
			ModelAndView modelAndView = new ModelAndView();
	    	modelAndView.setViewName("403");
	        return modelAndView;
		}
	}
}
