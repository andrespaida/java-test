import java.io.IOException;
import java.io.OutputStream;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

public class app {
    public static void main(String[] args) throws IOException {
        // Set the server to listen on port 9000
        HttpServer server = HttpServer.create(new java.net.InetSocketAddress(9000), 0);
        
        // Create a context and handle requests
        server.createContext("/", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                // HTML content with some style
                String response = "<html>" +
                                    "<head>" +
                                    "<meta charset='UTF-8'>" +
                                    "<meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
                                    "<title>Welcome to My Java Web App</title>" +
                                    "<style>" +
                                    "body { font-family: Arial, sans-serif; margin: 0; padding: 0; background-color: #f4f4f9; }" +
                                    "header { background-color: #333; color: #fff; padding: 15px; text-align: center; }" +
                                    "main { padding: 20px; text-align: center; }" +
                                    "h1 { color: #333; }" +
                                    "p { color: #555; font-size: 18px; }" +
                                    "footer { background-color: #333; color: #fff; text-align: center; padding: 10px; position: fixed; bottom: 0; width: 100%; }" +
                                    "</style>" +
                                    "</head>" +
                                    "<body>" +
                                    "<header>" +
                                    "<h1>Welcome to My Java Web App!</h1>" +
                                    "</header>" +
                                    "<main>" +
                                    "<p>This is a simple web application built with Java and the HttpServer API.</p>" +
                                    "<p>Feel free to explore more about Java web development!</p>" +
                                    "</main>" +
                                    "<footer>" +
                                    "<p>Made with <span style='color: red;'>&#x2764;</span> by Your Name</p>" +
                                    "</footer>" +
                                    "</body>" +
                                    "</html>";

                // Send HTTP response headers
                exchange.sendResponseHeaders(200, response.getBytes().length);
                
                // Write the response body
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        });

        // Start the server
        server.start();
        System.out.println("Server is listening on port 9000...");
    }
}