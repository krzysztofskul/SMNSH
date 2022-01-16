package pl.krzysztofskul.projectCharter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProjectCharterService {

    private ProjectCharterRepo projectCharterRepo;

    @Autowired
    public ProjectCharterService(ProjectCharterRepo projectCharterRepo) {
        this.projectCharterRepo = projectCharterRepo;
    }

    public ProjectCharter loadById(Long id) {
        return projectCharterRepo.findById(id).get();
    }

}
