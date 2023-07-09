package jarexample.user;

import jarexample.api.DummyAPI;

public final class APIUser {
  
  public static int taintSource(int i) {
    return i;
  }
  
  public static void taintSink(int i) {
    System.out.println("Sink: " + i);
  }
  
  public static void main(String[] args) {

    int num1 = taintSource(DummyAPI.parseInt(args[0]));
    int num2 = taintSource(DummyAPI.parseInt(args[1]));
    int sum = num1 + num2;
    taintSink(sum);
  }
  
}