package poc.pico;

import org.picocontainer.ComponentAdapter;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.LifecycleStrategy;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.injectors.ProviderAdapter;

/*
TODO
Goal: do cleanup tasks for an injected object when the container is shut down.
In particular, cleanup for an object provided by a ProviderAdapter, not that it should matter much.
The current output of the program is something like this, and only this:

    Creating instance for the first time
    poc.pico.MyDependent1@5cc7c2a6
    Instance already exists, reusing it
    poc.pico.MyDependent2@b97c004

I would expect more output from one of the log(...) calls, for lifecycle events.
Maybe, the actual mechanism must be implemented, not provided by pico.
See for reference PlatformLevel1 in SonarQube, and all the classes that implement pico's Startable.

Other references:
http://picocontainer.com/providers.html
https://stackoverflow.com/questions/30585194/how-do-i-get-picocontainer-to-start-stop-dispose-a-component-injected-by-a-facto
http://picocontainer.com/lifecycle.html
 */
public class App {

    private void log(String message) {
        System.out.println(message);
    }

    private void main() {
        LifecycleStrategy lifecycle = new LifecycleStrategy() {
            @Override
            public void start(Object component) {
                log("start!");
            }

            @Override
            public void stop(Object component) {
                log("stop!");
            }

            @Override
            public void dispose(Object component) {
                log("dispose!");
            }

            @Override
            public boolean hasLifecycle(Class<?> type) {
                log("hasLifecycle!");
                return true;
            }

            @Override
            public boolean isLazy(ComponentAdapter<?> adapter) {
                log("isLazy!");
                return true;
            }
        };

        MutablePicoContainer pico = new DefaultPicoContainer();
        //pico.addAdapter(new ProviderAdapter(lifecycle, new MyProvider()));
        pico.addAdapter(new MyProvider2());
        pico.addComponent(MyDependent1.class);
        pico.addComponent(MyDependent2.class);

        MyDependent1 myDependent1 = pico.getComponent(MyDependent1.class);
        System.out.println(myDependent1);
        MyDependent2 myDependent2 = pico.getComponent(MyDependent2.class);
        System.out.println(myDependent2);

        // don't know what I'm doing!
        pico.start();
        pico.stop();
    }

    public static void main(String[] args) {
        new App().main();
    }
}
