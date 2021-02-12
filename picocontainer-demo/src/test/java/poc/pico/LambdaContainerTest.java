package poc.pico;

import org.junit.Test;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;

import static org.assertj.core.api.Assertions.assertThat;

public class LambdaContainerTest {

    private final MutablePicoContainer pico = new DefaultPicoContainer();
    private final LambdaContainer underTest = new LambdaContainer(pico);

    @Test
    public void container_does_not_create_HttpClient_for_Feature() {
        Feature feature = underTest.getFeature();
        assertThat(feature).isNotNull();

        // could not find a way to verify that HttpClient was not actually created...
        // ... but the log is not present in the output

        // TODO write a dedicated test class to verify this behavior of pico
    }
}