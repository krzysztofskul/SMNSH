package pl.krzysztofskul.investor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestorRepo extends JpaRepository<Investor, Long> {
}
