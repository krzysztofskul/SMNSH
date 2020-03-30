package pl.krzysztofskul.initDB;

public class InitDB {

    private static int counter;
    private static InitDB instanceInitDB;

    private InitDB() {
    }

    public static InitDB getInstanceInitDB() {
        if (instanceInitDB == null) {
            instanceInitDB = new InitDB();
            counter = 0;
        }
        return instanceInitDB;
    }

    public static int getCounter() {
        return counter;
    }

    private static void setCounter(int counter) {
        InitDB.counter = counter;
    }

    public static void increaseCounter() {
        setCounter(getCounter()+1);
    }

}
