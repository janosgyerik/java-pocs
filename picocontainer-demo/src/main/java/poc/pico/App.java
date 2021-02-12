package poc.pico;

/*
TODO
This is a demo of using a container in a lambda handler.

Reusable resources must be created when the class is constructed.

The objects used by a lambda can be very complex to configure.

A practical pattern:

- Lambda constructor creates a container
- Lambda constructor triggers the initialization of reusable resources
- Functional components receive the container, and take their dependencies from it
- The container creates objects lazily: this is important for collaborating lambdas,
    which share the same container, without needing all objects from it.

Demo:

- A container has a fake DB client and a fake HTTP client
- The lambda handler initializes the DB client, but not the HTTP client which it doesn't use,
    leaving it uninitialized.
- The lambda delegates work to a complex object
- The complex object can use the DB client and other objects from the container

 */
public class App {
    public static void main(String[] args) {
        LambdaHandler lambdaHandler = new LambdaHandler();
        String input = args.length > 0 ? args[0] : "foo";
        String response = lambdaHandler.handleRequest(input);
        System.out.println(response);
    }
}
