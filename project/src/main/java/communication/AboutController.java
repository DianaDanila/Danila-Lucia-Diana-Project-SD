package communication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import bll.AnalysisBLL;
import bll.dto.AnalysisDTO;

@RestController
@RequestMapping("/about")//pagina about
public class AboutController {
	
	@Autowired
	private AnalysisBLL abll;

	@GetMapping
    public ModelAndView s() {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("about");
    	List<AnalysisDTO> aList = abll.findAll();
    	modelAndView.addObject("analysisList", aList);
        return modelAndView;
    }
}
