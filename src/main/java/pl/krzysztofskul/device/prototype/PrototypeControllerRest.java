package pl.krzysztofskul.device.prototype;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/smnsh2/devicesprototypes")
public class PrototypeControllerRest {

	PrototypeService prototypeService;
	
	/**
	 * Constructor
	 */
	@Autowired
	public PrototypeControllerRest(PrototypeService prototypeService) {
		this.prototypeService = prototypeService;
	}

	@GetMapping("/all/{modalityCode}")
	public List<Prototype> loadAllPrototypesByModalityCode(
				@PathVariable String modalityCode
			) {
		List<Prototype> prototypeList = prototypeService.loadAllByModalityCode(modalityCode);
		return prototypeList;
	}
	
}
