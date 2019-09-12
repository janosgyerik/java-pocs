package poc.pico;

import org.picocontainer.ComponentAdapter;
import org.picocontainer.LifecycleStrategy;
import org.picocontainer.Startable;
import org.picocontainer.injectors.Provider;
import org.picocontainer.injectors.ProviderAdapter;

public class MyProvider2 extends ProviderAdapter implements Startable {

  private MyClient instance;

  public MyClient provide() {
    if (instance == null) {
      log("Creating instance for the first time");
      instance = new MyClient();
    } else {
      log("Instance already exists, reusing it");
    }
    return instance;
  }

  @Override
  public boolean hasLifecycle(Class<?> type) {
    log("hasLifecycle? " + type);
    return true;
  }

  @Override
  public boolean isLazy(ComponentAdapter<?> adapter) {
    log("lazy?");
    return true;
  }

  @Override
  public void start(Object component) {
    log("start?");
  }

  @Override
  public void stop(Object component) {
    log("stop?");
  }

  @Override
  public void dispose(Object component) {
    log("dispose?");
  }

  private void log(String message) {
    System.out.println(message);
  }

  @Override
  public void start() {
    log("start provider");
  }

  @Override
  public void stop() {
    log("stop provider");
  }
}
