package pl.krzysztofskul.device.modality;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModalityRepo extends JpaRepository<Modality, Long>{

}
