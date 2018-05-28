package communication;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import bll.PacientBLL;
import bll.builder.PacientDTOBuilder;
import bll.dto.AnalysisDTO;
import bll.dto.PacientDTO;

@RestController
@RequestMapping("/pacient/signin")
public class SignPController {

	@Autowired
	private PacientBLL pbll;
	
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
		PacientDTO p = new PacientDTOBuilder()
				.name(name)
				.password(pass)
				.email(email)
				.address(address)
				.telephone(telephone)
				.analysis(new ArrayList<AnalysisDTO>())
				.build();
		System.out.println(p);
		pbll.insert(p);
		
		ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("home");
        return modelAndView;
	}
}
