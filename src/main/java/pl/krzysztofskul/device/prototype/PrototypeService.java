package pl.krzysztofskul.device.prototype;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PrototypeService {

	private PrototypeRepo prototypeRepo;

	@Autowired
	public PrototypeService(PrototypeRepo prototypeRepo) {
		super();
		this.prototypeRepo = prototypeRepo;
	}
	
	public List<Prototype> loadAll() {
		return prototypeRepo.findAll();
	}
	
	public Prototype loadById(Long id) {
		return prototypeRepo.findById(id).get();
	}
	
	public Prototype loadByModelName(String modelName) {
		return prototypeRepo.findByModelName(modelName);
	}
	
	public Prototype save(Prototype prototype) {
		return prototypeRepo.save(prototype);
	}
	
}
