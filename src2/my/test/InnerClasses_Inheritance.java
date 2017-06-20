package my.test;

import my.synchronzed.Singleton;

import java.lang.ref.WeakReference;
import java.util.*;

class InnerClasses_Inheritance {
    InnerClasses_Inheritance() {
    }

    volatile int a;

    static void doMainStatic() {
        System.out.println("doMainStatic");
    }

    static boolean prime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    static void printPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (prime(i)) System.out.println(i);
        }
    }

    class Employer {
        int a = 3;
        String s = new String("asdf");

        @Override
        protected void finalize() {
            try {
                super.finalize();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Inher2 inher2 = new Inher2(3);

        InnerClasses_Inheritance main = new InnerClasses_Inheritance();
        K c = main.new K1();
        c.method1();

        WeakReference<Employer> wre = new WeakReference<Employer>(main.new Employer());
//        Employer emp = wre.get();
        System.gc();
        System.out.println(wre.get());
//        System.out.println(emp);

        new Comparator<Employer>() {
            @Override
            public int compare(Employer o1, Employer o2) {
                return 0;
            }
        };

        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(565, 34);
        for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
            System.out.println(e);
        }
        printPrime(10);
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton != null);
        String s = "stress";
        System.out.println(new InnerClasses_Inheritance().firstUnrepeated(s.toCharArray()));
//        int[] arr = {};
//        arr[0]=0;
        main.doMainStatic();
        String s2 = new String("Another").intern();
        String s3 = "Another";
        if (s3 == s2) System.out.println("Yes");
        else System.out.println("NO");
        System.out.println("Hello world!");
        I i = () -> System.out.println("method 2");//Holly God! This is anonymous class with realized doI1() in one line
        i.doI1();
        i.doI3();
        I.doI4();//you can't invoke from i
    }

    abstract class A {
        abstract void do1();
    }

    interface I {
        void doI1();

        default void doI3() {
            System.out.println("I believe this is good");
        }

        static void doI4() {
            System.out.println("This is doI4");
        }
    }

    class A1 {
    }

    class B1 extends A1 {
    }

    class B extends A implements I {
        @Override
        void do1() {
        }

        @Override
        public void doI1() {
        }

        A1 doA1(A1 a) {
            return new A1();
        }
    }

    class C extends B {
        @Override
        B1 doA1(A1 b) {
            return new B1();
        }//covariant of returning types
    }

    char firstUnrepeated(char[] arr) {
        LinkedHashMap<Character, Integer> lhm = new LinkedHashMap<>();
        for (char c :
                arr) {
            if (lhm.containsKey(c)) lhm.put(c, 2);
            else lhm.put(c, 1);
        }
        Set<Character> set = lhm.keySet();
        for (char c : set) {
            if (lhm.get(c) == 1) return c;
        }
        return '-';
    }

    class K {
        private void method1() {
            System.out.println("Private 1");
        }
    }

    class K1 extends K {
        void method1() {
            System.out.println("Public 1");
        }
    }
}

class Inher {
    Inher(int i) {
    }
}

class Inher2 extends Inher {
    Inher2(int i) {
        super(i);//must be, because when you creating instance of Inher2 that will call superclass constructor and if sup constructor need parameters.
    }
}
//enum K{}