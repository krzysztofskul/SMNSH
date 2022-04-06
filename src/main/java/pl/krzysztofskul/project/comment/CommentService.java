package pl.krzysztofskul.project.comment;

import com.thedeanda.lorem.LoremIpsum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysztofskul.project.Project;
import pl.krzysztofskul.project.ProjectService;
import pl.krzysztofskul.user.UserService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class CommentService {

    private CommentRepo commentRepo;
    private ProjectService projectService;
    private UserService userService;

    @Autowired
    public CommentService(CommentRepo commentRepo, ProjectService projectService, UserService userService) {
        this.commentRepo = commentRepo;
        this.projectService = projectService;
        this.userService = userService;
    }

    /** CRUD METHODS */

    public void save(Comment comment) {
        commentRepo.save(comment);
    }

    public List<Comment> loadAllCommentsByProjectId(Long projectId)  {
        return commentRepo.findAllByProjectId(projectId);
    }

    /** crud methods end */

    /** demo comments creator*/
    public void createDemoComments() {
        for (Project project : projectService.loadAll()) {   	
        	save(new Comment(project, project.getSls(), LoremIpsum.getInstance().getWords(5, 10)));
        	save(new Comment(project, project.getProjectManager(), LoremIpsum.getInstance().getWords(5, 10)));
        }
    }

}
