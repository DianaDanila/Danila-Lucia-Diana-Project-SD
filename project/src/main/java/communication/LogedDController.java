package communication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import bll.DoctorBLL;
import bll.dto.DoctorDTO;

@RestController
@RequestMapping("/logeddoctor")
public class LogedDController {

	@Autowired
	private DoctorBLL dbll;
	
	@GetMapping
    public ModelAndView s() {
		ModelAndView loggedd = new ModelAndView();
		loggedd.setViewName("logeddoctor");
    	List<DoctorDTO> doctorsList = dbll.findAll();
    	loggedd.addObject("doctors", doctorsList);
        return loggedd;
    }
}
