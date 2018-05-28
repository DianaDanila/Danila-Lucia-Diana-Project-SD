package bll;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bll.builder.TypeDTOBuilder;
import bll.dto.TypeDTO;
import dal.model.Type;
import dal.repositories.RepositoryFactory;
import dal.repositories.TypeRepository;

@Service
public class TypeBLL {

	@Autowired // not null
	private RepositoryFactory trepo;
	
	public TypeDTO getByName(String type) {
		TypeRepository f = (TypeRepository) trepo.getRepository("Type");
		Type t = f.findByType(type);
		TypeDTO tdto = new TypeDTOBuilder()
				.type(t.getType())
				.build();
		return tdto;
	}
	
	public List<TypeDTO> findAll(){
		TypeRepository f = (TypeRepository) trepo.getRepository("Type");
		return f.findAll().stream().map(TypeDTO::new).collect(Collectors.toList());
	}
}
