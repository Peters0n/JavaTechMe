package webHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.apache.commons.io.IOUtils;

import java.io.*;

public class PresavePersonHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        var fis = new FileInputStream(new File("./public/index.html"));
        var fos = exchange.getResponseBody();
        System.out.println("PresavePersonHandle: " + exchange.getRequestURI());
        var page =new File("./public/index.html");

        exchange.sendResponseHeaders(200, page.length());
        IOUtils.copyLarge(fis, fos);
        fos.close();
    }
}
