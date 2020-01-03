package pl.krzysztofskul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysztofskul.investor.Investor;
import pl.krzysztofskul.investor.InvestorRepo;
import pl.krzysztofskul.recipient.Recipient;
import pl.krzysztofskul.recipient.RecipientRepo;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.UserRepo;

@Service
@Transactional
public class HomePageService {

    /**
     * params.
     */
    private UserRepo userRepo;
    private InvestorRepo investorRepo;
    private RecipientRepo recipientRepo;

    /** constr.
     *
     */
    @Autowired
    public HomePageService(
            UserRepo userRepo,
            InvestorRepo investorRepo,
            RecipientRepo recipientRepo
    ) {
        this.userRepo = userRepo;
        this.investorRepo = investorRepo;
        this.recipientRepo = recipientRepo;
    }

    /** methods
     *
     */

    public void createUsers() {
        for (int i = 1; i <= 9; i++) {
            User user = new User();
            user.setNameFirst("Name"+i);
            user.setNameLast("Surname"+i);
            user.setPosition("Some business position");
            userRepo.save(user);
        }
    }

    public void createInvestors() {
        for (int i = 1; i <= 9; i++) {
            Investor investor = new Investor();
            investor.setName("Investor no. "+i);
            investorRepo.save(investor);
        }
    }

    public void createRecipients() {
        for (int i = 1; i <= 9; i++) {
            Recipient recipient = new Recipient();
            recipient.setDepartment("Department "+i);
            recipientRepo.save(recipient);
        }
    }
}
