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
import bll.dto.PacientDTO;

@RestController
@RequestMapping("/pacient/update")
public class UpdatePController {
	
	@Autowired
	private PacientBLL pbll;
	
	@GetMapping
    public ModelAndView s() {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("update");
        return modelAndView;
    }
	
	@PostMapping(consumes = {"multipart/form-data"})
	public ModelAndView insert(@RequestPart("name") String name, @RequestPart("password") String pass) {
		PacientDTO now = pbll.getByName(name);
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
		pbll.update(name, now);
		
		ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("loggedpacient");
    	List<AnalysisDTO> list = pbll.getByName(name).getAnalysis();
    	modelAndView.addObject("analysisList", list);
        return modelAndView;
	}
}
