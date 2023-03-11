package pl.krzysztofskul.device.prototype;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.krzysztofskul.device.modality.Modality;

@Repository
public interface PrototypeRepo extends JpaRepository<Prototype, Long>{
	
	public Prototype findByModelName(String modelName);
	
	List<Prototype> findAllByModality(Modality modality);

}
