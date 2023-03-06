package pl.krzysztofskul.device.modality;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModalityGenerator {
	
	private ModalityRepo modalityRepo;

	@Autowired
	private ModalityGenerator(ModalityRepo modalityRepo) {
		super();
		this.modalityRepo = modalityRepo;
	}

	public String initModalityDb() {
		
		modalityRepo.save(new Modality("AT", "Advenced Therapy"));
		modalityRepo.save(new Modality("CT", "Computed Tomography"));
		modalityRepo.save(new Modality("MR", "Magnetic Resonance"));
		modalityRepo.save(new Modality("MI", "Molecular Imaging"));
		modalityRepo.save(new Modality("XPF", "Fluoroscopy"));
		modalityRepo.save(new Modality("XPR", "Radiogrpahy"));
		modalityRepo.save(new Modality("XPM", "Mammography"));
		modalityRepo.save(new Modality("XPU", "Urology"));
		modalityRepo.save(new Modality("US", "Ultrasound"));
		modalityRepo.save(new Modality("RO", "Radiation Oncology"));
		modalityRepo.save(new Modality("LD", "Laboratory Diagnostic"));
		modalityRepo.save(new Modality("SY", "Imaging Software"));
		modalityRepo.save(new Modality("SU", "Surgical Solutions"));
		
		return "redirect:/";
	}
	
}
