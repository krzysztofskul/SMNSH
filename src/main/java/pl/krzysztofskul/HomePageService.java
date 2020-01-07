package pl.krzysztofskul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysztofskul.device.Device;
import pl.krzysztofskul.device.DeviceService;
import pl.krzysztofskul.investor.Investor;
import pl.krzysztofskul.investor.InvestorService;
import pl.krzysztofskul.order.concept.Concept;
import pl.krzysztofskul.order.concept.ConceptService;
import pl.krzysztofskul.order.guideline.Guideline;
import pl.krzysztofskul.order.guideline.GuidelineService;
import pl.krzysztofskul.recipient.Recipient;
import pl.krzysztofskul.recipient.RecipientService;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.UserService;

import java.time.LocalDateTime;

@Service
@Transactional
public class HomePageService {

    /**
     * params.
     */
    private UserService userService;
    private DeviceService deviceService;
    private ConceptService conceptService;
    private GuidelineService guidelineService;
    private InvestorService investorService;
    private RecipientService recipientService;

    /** constr.
     *
     */
    @Autowired
    public HomePageService(
            UserService userService,
            DeviceService deviceService,
            ConceptService conceptService,
            GuidelineService guidelineService,
            InvestorService investorService,
            RecipientService recipientService
    ) {
        this.userService = userService;
        this.deviceService = deviceService;
        this.conceptService = conceptService;
        this.guidelineService = guidelineService;
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
            concept.setDevice(deviceService.loadById(Long.parseLong("1")));
            conceptService.save(concept);
            /** change dates of creation */
            concept = conceptService.loadById(Long.parseLong(String.valueOf(i)));
            concept.setDateTimeCreated(LocalDateTime.now().minusDays(31-i));
            conceptService.save(concept);
        }
        /** create additional concepts to first two users */
        for (int i = 7; i <= 8; i++) {
            Concept concept = new Concept();
            concept.setTitle("Concept title no. " + i);
            concept.setAuthor(userService.loadById(Long.parseLong(String.valueOf(1))));
            concept.setDescription("Drogi Marszałku, Wysoka Izbo. PKB rośnie. Różnorakie i rozwijanie struktur umożliwia w restrukturyzacji przedsiębiorstwa. Jednakże.");
            concept.setRemarks("Izbo, inwestowanie w większym stopniu.");
            concept.setDevice(deviceService.loadById(Long.parseLong("4")));
            conceptService.save(concept);
        }
        for (int i = 9; i <= 9; i++) {
            Concept concept = new Concept();
            concept.setTitle("Concept title no. " + i);
            concept.setAuthor(userService.loadById(Long.parseLong(String.valueOf(2))));
            concept.setDescription("Początek traktatu czasu panowania Fryderyka Wielkiego, Króla Pruskiego żył w.");
            concept.setRemarks("Na przykład w kolei przypadków.");
            concept.setDevice(deviceService.loadById(Long.parseLong("7")));
            conceptService.save(concept);
        }
    }

    public void createGuidelines() {
        /** create guidelines order fot first two users */
        for (int i = 1; i <= 2; i++) {
            Guideline guideline = new Guideline();
            guideline.setAuthor(userService.loadById(Long.parseLong(String.valueOf(i))));
            guideline.setTitle("Guidelines order");
            guideline.setConcept(conceptService.loadById(Long.parseLong(String.valueOf(i))));
            guidelineService.save(guideline);
        }
    }

    public void createDevices() {
        for (int i = 1; i <= 3; i++) {
            Device device = new Device();
            device.setModel("X-Ray device / model "+i);
            deviceService.save(device);
        }
        for (int i = 4; i <= 6; i++) {
            Device device = new Device();
            device.setModel("CT device / model "+(i-3));
            deviceService.save(device);
        }
        for (int i = 7; i <= 9; i++) {
            Device device = new Device();
            device.setModel("MRI device / model "+(i-6));
            deviceService.save(device);
        }
    }
}