package pl.krzysztofskul.device.prototype;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.krzysztofskul.device.Device;
import pl.krzysztofskul.device.modality.Modality;
import pl.krzysztofskul.device.modality.ModalityService;

@Service
@Transactional
public class PrototypeService {

	private PrototypeRepo prototypeRepo;
	private ModalityService modalityService;

	@Autowired
	public PrototypeService(
			PrototypeRepo prototypeRepo,
			ModalityService modalityService) {
		super();
		this.prototypeRepo = prototypeRepo;
		this.modalityService = modalityService;
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

	public Prototype loadByIdWithConfigurationList(Long id) {
		// TODO Auto-generated method stub
        Prototype prototype = this.loadById(id);
		Hibernate.initialize(prototype.getConfigurationList());
		return prototype;
	}
	
	public List<Prototype> loadAllByModalityCode(String modalityCode) {
		Modality modality = modalityService.loadByCode(modalityCode);
		List<Prototype> prototypeList = prototypeRepo.findAllByModality(modality);
		
		return prototypeList;
		
	}
	
}
