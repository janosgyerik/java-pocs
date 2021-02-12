package poc.pico;

public class Feature {

    private final DbClient dbClient;

    public Feature(DbClient dbClient) {
        this.dbClient = dbClient;
    }

    public String perform(String input) {
        return input + ": " + dbClient.find(input);
    }
}
