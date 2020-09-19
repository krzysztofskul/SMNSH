package pl.krzysztofskul.project.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentService {

    private CommentRepo commentRepo;

    @Autowired
    public CommentService(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    /** CRUD METHODS */

    public void save(Comment comment) {
        commentRepo.save(comment);
    }

    public List<Comment> loadAllCommentsByProjectId(Long projectId)  {
        return commentRepo.findAllByProjectId(projectId);
    }

    /** crud methods end */

}
