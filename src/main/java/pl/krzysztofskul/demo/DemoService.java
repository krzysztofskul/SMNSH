package pl.krzysztofskul.demo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
@Transactional
public class DemoService {

    public void startDemoMode() {
        Demo.getDemoInstance();
    }

}
