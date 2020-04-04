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

    public Demo getDemoMode() {
        return Demo.getDemoInstance();
    }

    public int getDemoStep() {
        return Demo.getStep();
    }

    public void increaseDemoStepByOne() {
        Demo.increaseStepByOne();
    }

    public void makeDemoStep(int step, HttpServletResponse httpServletResponse) throws IOException {
        if (step == 1) {
            httpServletResponse.sendRedirect("/initDB");
        }
    }

}
