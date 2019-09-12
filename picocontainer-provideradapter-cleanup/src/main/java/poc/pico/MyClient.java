package poc.pico;

import org.picocontainer.ComponentAdapter;
import org.picocontainer.LifecycleStrategy;
import org.picocontainer.Startable;

public class MyClient implements LifecycleStrategy, Startable {

  private void log(String message) {
    System.out.println(message);
  }

  @Override
  public void start(Object component) {
    log("start!!");
  }

  @Override
  public void stop(Object component) {
    log("stop!!");
  }

  @Override
  public void dispose(Object component) {
    log("dispose!!");
  }

  @Override
  public boolean hasLifecycle(Class<?> type) {
    log("hasLifecycle!!");
    return true;
  }

  @Override
  public boolean isLazy(ComponentAdapter<?> adapter) {
    log("isLazy!!");
    return true;
  }

  @Override
  public void start() {
    log("start me");
  }

  @Override
  public void stop() {
    log("stop me");
  }
}
