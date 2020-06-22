package pl.krzysztofskul.subcontractor;

import com.thedeanda.lorem.LoremIpsum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysztofskul.company.quality.QualityTypeEnum;
import pl.krzysztofskul.company.type.CompanyTypeService;

import java.util.List;
import java.util.Random;

@Service
@Transactional
public class SubcontractorService {

    private SubcontractorRepo subcontractorRepo;
    private CompanyTypeService companyTypeService;

    @Autowired
    public SubcontractorService(
            SubcontractorRepo subcontractorRepo,
            CompanyTypeService companyTypeService
    ) {
        this.subcontractorRepo = subcontractorRepo;
        this.companyTypeService = companyTypeService;
    }

    /** CRUD METHODS */

    public void save(Subcontractor subcontractor) {
        subcontractorRepo.save(subcontractor);
    }

    public List<Subcontractor> loadAll() {
        return subcontractorRepo.findAll();
    }

    public Subcontractor loadById(Long id) {
        return subcontractorRepo.findById(id).get();
    }

    /** OTHER METHODS */

    public void createTestSubcontractors() {
            for (int i = 0; i < 10 ; i++) {
                Subcontractor subcontractor = new Subcontractor();
                LoremIpsum loremIpsum = LoremIpsum.getInstance();
                subcontractor.setName(loremIpsum.getTitle(1));
                subcontractor.setType(companyTypeService.loadById(
                            (long) new Random().nextInt(companyTypeService.loadAll().size())+1
                        )
                );
                subcontractor.setCountry(loremIpsum.getCountry());
                subcontractor.setCity(loremIpsum.getCity());
                subcontractor.setPostalCode(loremIpsum.getZipCode());
                subcontractor.setStreet(loremIpsum.getName());
                subcontractor.setStreetNumber(new Random().nextInt(100));
                subcontractor.setEmail(loremIpsum.getEmail());
                switch (new Random().nextInt(3)) {
                    case 0: subcontractor.setQualityTypeEnum(QualityTypeEnum.GREEN); break;
                    case 1: subcontractor.setQualityTypeEnum(QualityTypeEnum.YELLOW); break;
                    case 2: subcontractor.setQualityTypeEnum(QualityTypeEnum.RED); break;
                }
                this.save(subcontractor);
            }

    }
}
