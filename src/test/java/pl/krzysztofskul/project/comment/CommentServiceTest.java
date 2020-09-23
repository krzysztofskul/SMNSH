package pl.krzysztofskul.project.comment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pl.krzysztofskul.AppConfig;
import pl.krzysztofskul.project.Project;
import pl.krzysztofskul.project.ProjectService;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
public class CommentServiceTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private CommentService commentService;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    @Order(1)
    public void /*save()*/ whenSaveCommentsToProject_shouldProjectInDbHaveCommentsRelated() {
        // given
        Project project = new Project();
        projectService.save(project);
        Comment comment1 = new Comment();
        Comment comment2 = new Comment();
        comment1.setProject(projectService.loadById(Long.parseLong("1")));
        commentService.save(comment1);
        comment2.setProject(projectService.loadById(Long.parseLong("1")));
        commentService.save(comment2);

        // when
        Project projectLoaded = projectService.loadById(Long.parseLong("1"));

        // should
        assertTrue(projectLoaded.getCommentList().size() == 2);
    }

    @Test
    @Order(2)
    public void whenLoadAllCommentsByProjectId_shouldReturnCommentsRelatedWithProject() {
        // given
            // data from test 1
        // when
        List<Comment> commentList = commentService.loadAllCommentsByProjectId(Long.parseLong("1"));
        // should
        assertTrue(commentList.size() == 2);
    }
}