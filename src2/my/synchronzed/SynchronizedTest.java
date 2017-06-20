package my.synchronzed;

public class SynchronizedTest {

    String str1 = "first";
    String str2 = "second";

    Thread trd1 = new Thread("My Thread 1"){
        public void run() {
            Singleton s = Singleton.getInstance();
            while(true){
//                System.out.println("Thread 1b :"+s.getCounter());
                s.incrementCounter();
                System.out.println("Thread 1a :"+s.counter);
                try {
                    this.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    Thread trd2 = new Thread("My Thread 2"){
        public void run(){
            Singleton s = Singleton.getInstance();
            while(true){
//                System.out.println("Thread 2b :"+s.getCounter());
//                s.incrementCounter();
                System.out.println("Thread 2a :"+s.counter);
                try {
                    this.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public static void main(String a[]){
        SynchronizedTest mdl = new SynchronizedTest();
        mdl.trd1.start();
        mdl.trd2.start();
    }
}