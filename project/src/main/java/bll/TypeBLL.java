package bll;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bll.builder.TypeDTOBuilder;
import bll.dto.TypeDTO;
import dal.model.Type;
import dal.repositories.TypeRepository;

@Service
public class TypeBLL {

	@Autowired // not null
	private TypeRepository trepo;
	
	public TypeDTO getByName(String type) {
		Type t = trepo.findByType(type);
		TypeDTO tdto = new TypeDTOBuilder()
				.type(t.getType())
				.build();
		return tdto;
	}
	
	public List<TypeDTO> findAll(){
		return trepo.findAll().stream().map(TypeDTO::new).collect(Collectors.toList());
	}
}
