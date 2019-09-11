package poc.okhttp3;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AppWithExplicitShutdown {

  private static final String URL = "https://google.com";

  private final OkHttpClient client = new OkHttpClient.Builder().build();

  private void log(String message) {
    System.out.println(message);
  }

  private String get(String url) throws IOException {
    Request request = new Request.Builder()
      .url(url)
      .get()
      .build();
    try (Response response = client.newCall(request).execute()) {
      if (response.isSuccessful()) {
        return response.body().string();
      }

      log(String.format("Request failed with https status: %s", response.code()));
      return null;
    }
  }

  private void main() throws IOException {
    log("Received content: " + get(URL));
    client.connectionPool().evictAll();

    log("Time to shut down... And probably it will, soon...");
  }

  public static void main(String[] args) throws IOException {
    new AppWithExplicitShutdown().main();
  }
}
