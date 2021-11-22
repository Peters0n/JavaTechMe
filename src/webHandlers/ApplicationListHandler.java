package webHandlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import phonebook.Application;
import phonebook.dao.ApplicationDAO;
import phonebook.dao.PhonebookDAO;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ApplicationListHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        var properties = new Properties();
        var dao = new ApplicationDAO(getConnection(properties));
        System.out.println("ListHandle:" + exchange.getRequestURI());

        var file = new File(("./public/ApplicationList.html"));
        String strResponse = Files.readString(Paths.get(file.getPath()));
        var personList = dao.findAll();
        var builder = new StringBuilder();
       /* builder.append("<table>");
        builder.append("<tr>");
        builder.append("<td>Id</td>");
        builder.append("<td>Firstname</td>");
        builder.append("<td>Lastname</td>");
        builder.append("<td>Age</td>");
        builder.append("<td>Address</td>");
        builder.append("<td>Status</td>");
        builder.append("</tr>");*/
        personList.forEach( x -> {
            builder.append("<tr>");
            builder.append("<td>" + x.getId() + "</td>");
            builder.append("<td>" + x.getFirstname() + "</td>");
            builder.append("<td>" + x.getLastname() + "</td>");
            builder.append("<td>" + x.getAge() + "</td>");
            builder.append("<td>" + x.getAddress() + "</td>");
            builder.append("<td>" + x.getStatus() + "</td>");
            builder.append("</tr>");
        });
       // builder.append("</table>");
        var response = strResponse.replace("{{content}}", builder.toString()).getBytes(StandardCharsets.UTF_8);
        exchange.sendResponseHeaders(200, response.length);
        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(response);
        outputStream.close();

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
