package seminarNine.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import seminarNine.repository.IUserStorage;

import java.io.*;

public class UserHandler implements HttpHandler {
    private final IUserStorage userStorage;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public UserHandler(IUserStorage userStorage) {
        this.userStorage = userStorage;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestMethod = exchange.getRequestMethod();
        StringBuilder responseBody = new StringBuilder();
        exchange.getResponseHeaders().set("Content-Type", "application/json");

        switch (requestMethod) {
            case "GET":
                responseBody.append(objectMapper.writeValueAsString(userStorage.getUsers()));
                exchange.sendResponseHeaders(200, responseBody.length());
                break;
            case "POST":
                try {
                    String requestBody = getRequestBodyString(exchange.getRequestBody());
                    JsonNode jsonNode = objectMapper.readTree(requestBody);
                    String userName = jsonNode.get("userName").asText();
                    User newUser = userStorage.addUser(userName);
                    responseBody.append(objectMapper.writeValueAsString(newUser));
                    exchange.sendResponseHeaders(201, responseBody.length());
                } catch (Exception e) {
                    responseBody.append("POST error").append(e.getMessage());
                    exchange.sendResponseHeaders(401, responseBody.length());
                }
                break;
            case "DELETE":
                try {
                    String requestBody = getRequestBodyString(exchange.getRequestBody());
                    JsonNode jsonNode = objectMapper.readTree(requestBody);
                    int userId = jsonNode.get("userId").asInt();
                    responseBody.append(objectMapper.writeValueAsString(userStorage.deleteUser(userId)));
                    exchange.sendResponseHeaders(200, responseBody.length());
                } catch (Exception e) {
                    responseBody.append("DELETE POST error ").append(e.getMessage());
                    exchange.sendResponseHeaders(401, responseBody.length());
                }
                break;
            default:

        }

        try (OutputStream os = exchange.getResponseBody()) {
            os.write(responseBody.toString().getBytes());
        }

    }

    private String getRequestBodyString(InputStream inputStream) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            return reader.readLine();
        }
    }
}
