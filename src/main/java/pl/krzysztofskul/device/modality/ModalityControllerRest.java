package pl.krzysztofskul.device.modality;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/modality")
public class ModalityControllerRest {

	ModalityService modalityService;

	/**
	 * Constructor
	 */
	@Autowired
	public ModalityControllerRest(ModalityService modalityService) {
		this.modalityService = modalityService;
	}
	
	@GetMapping("/all")
	public List<Modality> getAllModalities() {
		return modalityService.loadAll();
	}
}
