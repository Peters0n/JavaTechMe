package webHandlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ApplicationPreSaveCssHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        var fis = new FileInputStream(new File("./public/style.css"));
        var fos = exchange.getResponseBody();
        System.out.println("PresaveApplicationHandle: " + exchange.getRequestURI());
        var page =new File("./public/style.css");

        exchange.sendResponseHeaders(200, page.length());
        IOUtils.copyLarge(fis, fos);
        fos.close();
    }
}
