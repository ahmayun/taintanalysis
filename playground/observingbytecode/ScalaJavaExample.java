import scala.Predef$;
import scala.StringContext;
import scala.collection.Seq;
import scala.collection.immutable.StringOps;
import scala.runtime.BoxesRunTime;

public final class ScalaJavaExample {
  public static final ScalaJavaExample$ MODULE$;
  
  public static int taintSource(int i) {
    return i;
  }
  
  public static void taintSink(int i) {
    Predef$.MODULE$.println("Sink");
  }
  
  public static void main(String[] args) {

    int num1 = taintSource((new StringOps(Predef$.MODULE$.augmentString(args[0]))).toInt());
    int num2 = taintSource((new StringOps(Predef$.MODULE$.augmentString(args[1]))).toInt());
    int sum = num1 + num2;
    (new String[4])[0] = "The sum of ";
    (new String[4])[1] = " and ";
    (new String[4])[2] = " is: ";
    (new String[4])[3] = "";
    Predef$.MODULE$.println((new StringContext((Seq)Predef$.MODULE$.wrapRefArray((Object[])new String[4]))).s((Seq)Predef$.MODULE$.genericWrapArray(new Object[] { BoxesRunTime.boxToInteger(num1), BoxesRunTime.boxToInteger(num2), BoxesRunTime.boxToInteger(sum) })));
    taintSink(sum);
  }
  
}