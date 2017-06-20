package my.test;

/**
 * Created by olehb on 28.10.16.
 * With lazy initialization. There is early, after class come to JVM
 */
public class PerfectSingleton {
    private static volatile PerfectSingleton instance;
    private PerfectSingleton(){}
    public static PerfectSingleton getInstance(){
        if(instance == null)
            synchronized (PerfectSingleton.class){
                if(instance == null) instance = new PerfectSingleton();
            }
        return instance;
    }
    class inher extends PerfectSingleton{}
}
