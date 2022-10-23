package pl.krzysztofskul.SapCustomer;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SapCustomerService {
	
	private SapCustomerRepo sapCustomerRepo;

	@Autowired
	public SapCustomerService(SapCustomerRepo sapCustomerRepo) {
		super();
		this.sapCustomerRepo = sapCustomerRepo;
	}
	
	public void save(SapCustomer sapCustomer) {
		sapCustomerRepo.save(sapCustomer);
	}

	public List<SapCustomer> loadAll() {
		return sapCustomerRepo.findAll();
	}
	
	public SapCustomer loadById(Long idNumberSap) {
		return sapCustomerRepo.findById(idNumberSap).get();
	}
	
}
