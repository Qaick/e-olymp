package my.test;//: control/LabeledFor.java
// For loops with "labeled break" and "labeled continue."


public class BMGotoAlternative {
    public static void main(String[] args) {
        int i = 0;
        outer: // Can't have statements here
        for(; true ;) { // infinite loop
            inner: // Can't have statements here
            for(; i < 10; i++) {
                print("i = " + i);
                if(i == 2) {
                    print("continue");
                    continue;
                }
                if(i == 3) {
                    print("break");
                    i++; // Otherwise i never
                    // gets incremented.
                    break;
                }
                if(i == 7) {
                    print("continue outer");
                    i++; // Otherwise i never
                    // gets incremented.
                    continue outer;
                }
                if(i == 8) {
                    print("break outer");
                    break outer;
                }
                if(i==9){
                    print("as;dfasdf");
                }
                for(int k = 0; k < 5; k++) {
                    if(k == 3) {
                        print("continue inner");
                        continue inner;
                    }
                }
            }
        }
        // Can't break or continue to labels here
    }
    public static void print(String s){
        System.out.println(s);
    }
} 