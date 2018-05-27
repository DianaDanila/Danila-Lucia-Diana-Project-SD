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
@RequestMapping("/doctor/update")
public class UpdateDController {
	@Autowired
	private DoctorBLL dbll;

	@GetMapping
    public ModelAndView s() {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("update");
        return modelAndView;
    }
	
	@PostMapping(consumes = {"multipart/form-data"})
	public ModelAndView insert(@RequestPart("name") String name, @RequestPart("password") String pass/*, 
			@RequestPart("email") String email, @RequestPart("address") String address, 
			@RequestPart("telephone") String telephone*/) {
		DoctorDTO now = dbll.getByName(name);
		//if(pass !=null) {
			now.setPassword(pass);
		//}
		/*if(email !=null) {
			now.setEmail(email);
		}
		if(address !=null) {
			now.setAddress(address);
		}
		if(telephone!=null) {
			now.setTelephone(telephone);
		}*/
		dbll.update(name, now);
		
		ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("logeddoctor");
    	List<DoctorDTO> doctorsList = dbll.findAll();
    	modelAndView.addObject("doctors", doctorsList);
        return modelAndView;
	}
}
