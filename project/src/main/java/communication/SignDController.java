package communication;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import bll.DoctorBLL;
import bll.builder.DoctorDTOBuilder;
import bll.dto.AnalysisDTO;
import bll.dto.DoctorDTO;

@RestController
@RequestMapping("/doctor/signin")
public class SignDController {

	@Autowired
	private DoctorBLL dbll;

	@GetMapping
    public ModelAndView s() {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("signin");
        return modelAndView;
    }
	
	@PostMapping(consumes = {"multipart/form-data"})
	public ModelAndView insert(@RequestPart("name") String name, @RequestPart("password") String pass, 
			@RequestPart("email") String email, @RequestPart("address") String address, 
			@RequestPart("telephone") String telephone) {
		DoctorDTO d = new DoctorDTOBuilder()
				.name(name)
				.password(pass)
				.email(email)
				.address(address)
				.telephone(telephone)
				.analysis(new ArrayList<AnalysisDTO>())
				.build();
		dbll.insert(d);
		
		ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("login1");;
        return modelAndView;
	}
}
