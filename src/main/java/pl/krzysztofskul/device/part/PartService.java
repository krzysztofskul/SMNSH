package pl.krzysztofskul.device.part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PartService {

    private PartRepo partRepo;

    @Autowired
    public PartService(PartRepo partRepo) {
        this.partRepo = partRepo;
    }

    public Part save(Part part) {
        return partRepo.save(part);
    }

    public List<Part> loadAll() {
        return partRepo.findAll();
    }

    public Part loadById(Long id) {
        return partRepo.findById(id).get();
    }

}
