package pl.krzysztofskul.demo;

/* SINGLETON */
public class Demo {

    /* PARAMETERS */

    private static Demo demoInstance;
    private static int step;

    /* CONSTRUCTOR */

    private Demo() {}

    /* GETTERS AND SETTERS */

    public static int getStep() {
        return Demo.step;
    }

    public static void setStep(int step) {
        Demo.step = step;
    }

    /* METHODS */

    public static Demo getDemoInstance() {
        if (demoInstance == null) {
            Demo.step = 0;
            return new Demo();
        }
        return demoInstance;
    }

    public static void increaseStepByOne() {
        Demo.setStep(getStep()+1);
    }
}
