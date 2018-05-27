package communication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import bll.AnalysisBLL;
import bll.DoctorBLL;
import bll.PacientBLL;
import bll.TypeBLL;
import bll.builder.AnalysisDTOBuilder;
import bll.builder.TypeDTOBuilder;
import bll.dto.AnalysisDTO;
import bll.dto.DoctorDTO;
import bll.dto.PacientDTO;
import bll.dto.TypeDTO;

@RestController
@RequestMapping("/createanalysis")
public class CreateAController {

	@Autowired
	private PacientBLL pbll;
	
	@Autowired
	private DoctorBLL dbll;
	
	@Autowired
	private TypeBLL tbll;
	
	@Autowired
	private AnalysisBLL abll;
	
	@GetMapping
    public ModelAndView s() {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("createanalysis");
    	List<PacientDTO> pList = pbll.findAll();
    	modelAndView.addObject("pacients", pList);
    	List<DoctorDTO> dList = dbll.findAll();
    	modelAndView.addObject("doctors", dList);
    	List<TypeDTO> tList = tbll.findAll();
    	modelAndView.addObject("types", tList);
        return modelAndView;
    }
	
	@PostMapping(consumes = {"multipart/form-data"})
	public ModelAndView create(@RequestPart("name") String name, @RequestPart("result") String result, 
			@RequestPart("pacient") String pacient, @RequestPart("doctor") String doctor, 
			@RequestPart("type") String type) {
		
		List<TypeDTO> t = new ArrayList<TypeDTO>();
		t.add(new TypeDTOBuilder().type(type).build());
		AnalysisDTO a = new AnalysisDTOBuilder()
				.name(name)
				.result(result)
				.pacient(pacient)
				.doctor(doctor)
				.types(t)
				.build();
		abll.insert(a);
		
		ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("logeddoctor");
    	List<DoctorDTO> doctorsList = dbll.findAll();
    	modelAndView.addObject("doctors", doctorsList);
        return modelAndView;
	}
}
