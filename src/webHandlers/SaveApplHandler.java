package webHandlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import phonebook.dao.ApplicationDAO;
import phonebook.dao.PhonebookDAO;
import phonebook.entity.Application;
import phonebook.entity.Person;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Properties;
import java.util.stream.Collectors;

public class SaveApplHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {

        var inputStream = exchange.getRequestBody();
        int c = 0;
        var body = new StringBuilder();
        while ((c = inputStream.read()) != -1) {
            body.append((char) c);
        }
        var args = Arrays.stream(body.toString().split("&")).collect(Collectors.toList());
        var fields = new HashMap<String, String>();
        args.forEach(arg -> fields.put(arg.split("=")[0], arg.split("=")[1]));
        fields.keySet().forEach(System.out::println);
        fields.values().forEach(System.out::println);

        var properties = new Properties();
        Connection connection = getConnection(properties);

        var dao = new ApplicationDAO(connection);
        var application = new Application();
        application.setFirstname(fields.get("firstname"));
        application.setLastname(fields.get("lastname"));
        application.setAddress(fields.get("address"));
        application.setAge(Integer.parseInt(fields.get("age")));
        application.setStatus(Integer.parseInt(fields.get("status")));
        dao.save(application);
        var file = new File("./public/SavedAppl.html");
        var response = Files.readAllBytes(Paths.get(file.getPath()));
        exchange.sendResponseHeaders(200, response.length);
        OutputStream os = exchange.getResponseBody();
        os.write(response);
        os.close();
    }

    private static Connection getConnection(Properties properties) {
        Connection connection = null;
        try {
            // loading properties
            //var properties = new Properties();
            try (var in = Files.newInputStream(Paths.get("database.properties"))) {
                properties.load(in);
            }

            Class.forName("com.mysql.cj.jdbc.Driver"); // loading MySQL driver for java.sql

            return DriverManager.getConnection(
                    properties.getProperty("url"),
                    properties.getProperty("username"),
                    properties.getProperty("password"));

        } catch (SQLException | ClassNotFoundException | IOException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
