package pl.krzysztofskul.device.device3rd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Device3rdService {
	
	private Device3rdRepo device3rdRepo;

	/**
	 * @param device3rdRepo
	 */
	@Autowired
	public Device3rdService(Device3rdRepo device3rdRepo) {
		this.device3rdRepo = device3rdRepo;
	}
	
	public Device3rd saveAndReturn(Device3rd device3rd) {
		return device3rdRepo.save(device3rd);
	}
	
}
