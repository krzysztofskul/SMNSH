package pl.krzysztofskul.SapCustomer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SapCustomerRepo extends JpaRepository<SapCustomer, Long> {

}
