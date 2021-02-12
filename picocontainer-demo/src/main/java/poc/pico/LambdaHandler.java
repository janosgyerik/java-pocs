package poc.pico;

public class LambdaHandler {

    private final Feature feature;

    public LambdaHandler() {
        this(new LambdaContainer());
    }

    // visible for testing
    LambdaHandler(LambdaContainer container) {
        this.feature = container.getFeature();
    }

    String handleRequest(String input) {
        return feature.perform(input);
    }
}
