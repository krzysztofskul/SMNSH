package pl.krzysztofskul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysztofskul.investor.Investor;
import pl.krzysztofskul.investor.InvestorService;
import pl.krzysztofskul.order.concept.Concept;
import pl.krzysztofskul.order.concept.ConceptService;
import pl.krzysztofskul.recipient.Recipient;
import pl.krzysztofskul.recipient.RecipientService;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.UserService;

@Service
@Transactional
public class HomePageService {

    /**
     * params.
     */
    private UserService userService;
    private ConceptService conceptService;
    private InvestorService investorService;
    private RecipientService recipientService;

    /** constr.
     *
     */
    @Autowired
    public HomePageService(
            UserService userService,
            ConceptService conceptService,
            InvestorService investorService,
            RecipientService recipientService
    ) {
        this.userService = userService;
        this.conceptService = conceptService;
        this.investorService = investorService;
        this.recipientService = recipientService;
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
            userService.save(user);
        }
    }

    public void createInvestors() {
        for (int i = 1; i <= 9; i++) {
            Investor investor = new Investor();
            investor.setName("Investor no. "+i);
            investorService.save(investor);
        }
    }

    public void createRecipients() {
        for (int i = 1; i <= 9; i++) {
            Recipient recipient = new Recipient();
            recipient.setDepartment("Department "+i);
            recipientService.save(recipient);
        }
    }

    public void createConcepts() {
        /** create one concept for first six users */
        for (int i = 1; i <= 6; i++) {
            Concept concept = new Concept();
            concept.setTitle("Concept title no. " + i);
            concept.setAuthor(userService.loadById(Long.parseLong(String.valueOf(i))));
            concept.setDescription("Lorem ipsum dolor sit amet mi eget sapien. Aliquam quis tortor. Cras volutpat ligula enim.");
            concept.setRemarks("Phasellus vitae ante. Duis non.");
            conceptService.save(concept);
        }
        /** create additional concepts to first two users */
        for (int i = 7; i <= 8; i++) {
            Concept concept = new Concept();
            concept.setTitle("Concept title no. " + i);
            concept.setAuthor(userService.loadById(Long.parseLong(String.valueOf(1))));
            concept.setDescription("Drogi Marszałku, Wysoka Izbo. PKB rośnie. Różnorakie i rozwijanie struktur umożliwia w restrukturyzacji przedsiębiorstwa. Jednakże.");
            concept.setRemarks("Izbo, inwestowanie w większym stopniu.");
            conceptService.save(concept);
        }
        for (int i = 9; i <= 9; i++) {
            Concept concept = new Concept();
            concept.setTitle("Concept title no. " + i);
            concept.setAuthor(userService.loadById(Long.parseLong(String.valueOf(2))));
            concept.setDescription("Początek traktatu czasu panowania Fryderyka Wielkiego, Króla Pruskiego żył w.");
            concept.setRemarks("Na przykład w kolei przypadków.");
            conceptService.save(concept);
        }
    }
}
