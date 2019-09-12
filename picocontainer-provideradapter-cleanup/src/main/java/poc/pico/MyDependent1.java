package poc.pico;

public class MyDependent1 {
  private final MyClient client;

  public MyDependent1(MyClient client) {
    this.client = client;
  }
}
