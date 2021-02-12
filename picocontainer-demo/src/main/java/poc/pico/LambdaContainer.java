package poc.pico;

import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.PicoContainer;

public class LambdaContainer {

    private final PicoContainer pico;

    public LambdaContainer() {
        this(new DefaultPicoContainer());
    }

    // visible for testing
    LambdaContainer(MutablePicoContainer pico) {
        pico.addComponent(Feature.class);
        pico.addComponent(DbClient.class);
        pico.addComponent(HttpClient.class);

        this.pico = pico;
    }

    public Feature getFeature() {
        return pico.getComponent(Feature.class);
    }
}
