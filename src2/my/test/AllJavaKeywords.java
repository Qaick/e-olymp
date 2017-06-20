package my.test;

import static my.test.AllKeywords.Mood.solar;

@javax.annotation.Generated("")
public class AllKeywords extends Object implements Cloneable{
    //transient - excepts fienld from serialization
    private static transient Object o;
    //volatile - field changes will be synchronized(threads)
    volatile Object o2 = null;
    AllKeywords ak = new AllKeywords();
    protected interface Interface{
        //holly default method realization in interface
        default void get(){}
    };
    abstract class AbstractClass{
        //abstract methods can be only in abstract class(or interface don't need keyword)
        //synchronized modifier blocks next thread call to this method
        synchronized void get(){}
    };
    enum Mood{solar,cloudy}//have real values {0,1}
    final Mood mood = solar;
    native int square(int i);
    void get() throws CloneNotSupportedException{
        return;
    }

    boolean bool=false;
    char c;
    byte b;
    short s;
    int a =0;
    long l;
    float f;
    double d;
    {
        assert a!=-1;//if a==-1 throws AssertionError
        super.toString();//refers to superclass
        this.a=7;//refers to instance of this class
        try {
            o=ak.clone();
            throw new CloneNotSupportedException();
        } catch (CloneNotSupportedException e) {
        }finally {}
        do{
            if(bool) bool=false;
            else break;
            continue;
        }while(ak instanceof AllKeywords);//instanceof (instance - экземпляр)
        for(int j =0;j<3;j++){}
        switch(a){
            case 0:
            bool = true;
            default:
        }
        System.out.print("@");
    }
}
/*keywords 50 reserved words(identifiers) //wiki says @ is a keyword too but not for oracle
abstract+ In front of a `class` keyword, prevents this class from being directly instantiated. In front of a method signature, allows the implementation of this method to be deferred to an inheriting class.
assert+ Assert describes a predicate (a true–false statement)
boolean+ Used to end the execution in the current loop body.
break+
byte+
case+
catch+
char+
class+
const - беспощадно неюзабельное
continue+
default+
do+
double+
else+
enum+
extends+
final+
finally+
float+
for+
goto - not used
if+
implements+
import+
instanceof+ A binary operator
int+
interface+
long+
native+ Used in method declarations to specify that the method is not implemented in the same Java source file, but rather in another language
new+
package+
private+
protected+
public+
return+
short+
static+
strictfp - strict floating point(строгий, ограничение для архитектур с большей точностью)
super+
switch+
synchronized+
this+
throw+
throws+
transient+
try+
void+
volatile+
while+

Reserved literal values:
true+
false+
null+
 */