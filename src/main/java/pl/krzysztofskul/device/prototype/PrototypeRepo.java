package pl.krzysztofskul.device.prototype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrototypeRepo extends JpaRepository<Prototype, Long>{
	
	public Prototype findByModelName(String modelName);

}
