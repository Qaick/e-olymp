package my.synchronzed;

public class Singleton {
    private static Singleton instance;
    public int counter = 0;

    private Singleton() {   }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    public  int getCounter(){
        return counter;
    }
    public  void incrementCounter(){
        counter++;
    }
}