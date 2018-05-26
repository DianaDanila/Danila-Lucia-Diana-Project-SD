package communication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import bll.PacientBLL;
import bll.dto.AnalysisDTO;

@RestController
@RequestMapping("/pacient/login")
public class LogInPController {
	@Autowired
	private PacientBLL pbll;

	@GetMapping
    public ModelAndView s() {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("login1");
        return modelAndView;
    }
	
	@PostMapping(consumes = {"multipart/form-data"})
	public ModelAndView login(@RequestPart("user") String name, @RequestPart("password") String pass) {
		
		if(pbll.login(name, pass)) {
			ModelAndView modelAndView = new ModelAndView();
	    	modelAndView.setViewName("loggedpacient");
	    	List<AnalysisDTO> list = pbll.getByName(name).getAnalysis();
	    	modelAndView.addObject("analysisList", list);
	        return modelAndView;
		}
		else {
			ModelAndView modelAndView = new ModelAndView();
	    	modelAndView.setViewName("403");
	        return modelAndView;
		}
	}
}
