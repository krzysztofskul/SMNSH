package pl.krzysztofskul.device.part;

import com.thedeanda.lorem.LoremIpsum;

import java.io.Serializable;
import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PartDemoGenerator implements Serializable {

    /**
     * params., constr., getter
     */

    private static PartDemoGenerator partDemoGenerator;
    private static List<Part> partDemoList = new ArrayList<>();

    private PartDemoGenerator() {
    }

    public static PartDemoGenerator getPartDemoGenerator() {
        if (partDemoGenerator == null) {
            partDemoGenerator = new PartDemoGenerator();
        }
        return partDemoGenerator;

    }

    /**
     * methods
     */

    private void createPartsDemo() {
        for (int i = 0; i < 100; i++) {
            partDemoList.add(new Part(LoremIpsum.getInstance().getWords(2), BigDecimal.valueOf(new Random().nextDouble()*1000+1), LoremIpsum.getInstance().getWords(5,10)));
        }
    }

    public List<Part> getPartDemoList() {
        if (partDemoList == null || partDemoList.size() == 0) {
            this.createPartsDemo();
        }
        return partDemoList;
    }

}
