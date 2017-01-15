package test;

import sun.misc.Launcher;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;

import static test.SweetShop.*;

class Candy {
  static { print("Loading Candy"); }
  public void method1(){}
//  @Override
//  private boolean equals(Object o) {return true;}
}

class Gum {
  static { print("Loading Gum"); }
}

class Cookie {
  static { print("Loading Cookie"); }
}

public class SweetShop {
  public static void main(String[] args) {
    print("inside main");
    new Candy();
    complex(new int[]{1, 2, 3});
    Arrays.stream(Candy.class.getMethods()).forEach(SweetShop::print);
    Arrays.stream(Candy.class.getMethods()).forEach(s -> SweetShop.print(s));
    Arrays.asList(Candy.class.getMethods()).stream().forEach(SweetShop::print);

    /*
    return;
    for (Method meth: Candy.class.getMethods())
    print(Candy.class.getClassLoader().getClass().getName());
    print("After creating Candy");
    try {
      Class.forName("test.Bi");
    } catch(ClassNotFoundException e) {
      print("Couldn't find Gum");
    }
    print("After Class.forName(\"Gum\")");
    new Cookie();
    print("After creating Cookie");
    */
  }
//  @FunctionalInterface
//  public interface IntOperator {
//
//    /**
//     * Applies this operator to the given operands.
//     *
//     * @param left the first operand
//     * @param right the second operand
//     * @return the operator result
//     */
//    int applyAsInt(int left, int right);
//  }



//  static int max() {
//    return reduce(SweetShop::complex);
//  }

  static int complex(int... a) {
    System.out.println("holly: "+ a.getClass().getName());
    int ans = 0;
    for (int i: a) {
      ans+=i;
    }
    return ans;
  }
  public static void print(Object s) {
    System.out.println(s);
  }
}
