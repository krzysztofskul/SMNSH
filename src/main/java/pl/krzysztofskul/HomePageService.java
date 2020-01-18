package pl.krzysztofskul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import pl.krzysztofskul.device.Device;
import pl.krzysztofskul.device.DeviceService;
import pl.krzysztofskul.investor.Investor;
import pl.krzysztofskul.investor.InvestorService;
import pl.krzysztofskul.order.Status;
import pl.krzysztofskul.order.concept.Concept;
import pl.krzysztofskul.order.concept.ConceptService;
import pl.krzysztofskul.order.guideline.Guideline;
import pl.krzysztofskul.order.guideline.GuidelineService;
import pl.krzysztofskul.recipient.Recipient;
import pl.krzysztofskul.recipient.RecipientService;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.UserBusinessPosition;
import pl.krzysztofskul.user.UserService;
import pl.krzysztofskul.user.avatar.Avatar;
import pl.krzysztofskul.user.avatar.AvatarService;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
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
    private AvatarService avatarService;

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
            RecipientService recipientService,
            AvatarService avatarService
    ) {
        this.userService = userService;
        this.deviceService = deviceService;
        this.conceptService = conceptService;
        this.guidelineService = guidelineService;
        this.investorService = investorService;
        this.recipientService = recipientService;
        this.avatarService = avatarService;
    }

    /** methods
     *
     */

    public void createUsers() {
        /** create 2 users at planner business position */
        for (int i = 1; i <= 2; i++) {
            User user = new User();
            user.setNameFirst("Name"+i);
            user.setNameLast("Surname"+i);
            user.setEmail(user.getNameFirst()+user.getNameLast()+"@test.test");
            user.setPassword("test");
            user.setBusinessPosition(UserBusinessPosition.PLANNER);
            userService.save(user);
        }
        /** create 6 users at project manager business position */
        for (int i = 3; i <= 9; i++) {
            User user = new User();
            user.setNameFirst("Name"+i);
            user.setNameLast("Surname"+i);
            user.setEmail(user.getNameFirst()+user.getNameLast()+"@test.test");
            user.setPassword("test");
            user.setBusinessPosition(UserBusinessPosition.PROJECT_MANAGER);
            userService.save(user);
        }

        //todo: user's avatar
        /** save avatar for 1st user */
        /* load File */
        //todo?: del / convert File to MultiPartFile
        //File file = new File("/resources/img/avatars/avatar-01_128x128px.png");
        /* convert File to MultipartFile */

        /* save MultipartFile to DB*/
        //avatarService.save(multipartFile);

        //byte[] byteFile = new byte[(int) file.length()];
        //try {
        //    FileInputStream fileInputStream = new FileInputStream(file);
        //    /* convert file into array of bytes */
        //    fileInputStream.read(byteFile);
        //    fileInputStream.close();
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}
        /* create Avatar from loaded file */
        //Avatar avatar = new Avatar();
        //avatar.setData(byteFile);
        /* save avatar to DB */
        //avatarService.save(avatar);
        /* connect avatar to user */
        //userService.loadById(Long.parseLong("1")).setAvatar(avatar);
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
            concept.setPriority("!");
            concept.setPlanner(userService.loadById(Long.parseLong(String.valueOf(1))));
            conceptService.save(concept);
            /** change dates of creation */
            concept = conceptService.loadById(Long.parseLong(String.valueOf(i)));
            concept.setDateTimeCreated(LocalDateTime.now().minusDays(31-i));
            concept.setDateTimeDeadline(LocalDateTime.now().plusDays(7+i));
            concept.setStatus(Status.IN_PROGRESS);
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
            concept.setPriority("!");
            concept.setDateTimeDeadline(LocalDateTime.now().plusDays(7+i));
            conceptService.save(concept);
        }
        for (int i = 9; i <= 9; i++) {
            Concept concept = new Concept();
            concept.setTitle("Concept title no. " + i);
            concept.setAuthor(userService.loadById(Long.parseLong(String.valueOf(2))));
            concept.setDescription("Początek traktatu czasu panowania Fryderyka Wielkiego, Króla Pruskiego żył w.");
            concept.setRemarks("Na przykład w kolei przypadków.");
            concept.setDevice(deviceService.loadById(Long.parseLong("7")));
            concept.setPriority("!");
            concept.setDateTimeDeadline(LocalDateTime.now().plusDays(7+i));
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
            guideline.setStatus(Status.ORDERED_WAITING);
            guideline.setPriority("!!!");
            guideline.setDateTimeDeadline(LocalDateTime.now().plusDays(14+2*i));
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