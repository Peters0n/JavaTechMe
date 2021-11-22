package webServer;

import com.sun.net.httpserver.HttpServer;
import webHandlers.*;

import java.io.IOException;
import java.net.InetSocketAddress;

public class WebServer {
    public static void main(String[] args) {
        HttpServer server = null;
        try {
            server = HttpServer.create(new InetSocketAddress(9000), 0);
            server.createContext("/saveapplication", new SaveApplHandler());// сохр-е польз-ля в **Applic-n** - 2е окно
            server.createContext("/applsave", new ApplicationPreSaveHandler());// сохр-е польз-ля в **Applic-n**
            server.createContext("/style.css", new ApplicationPreSaveCssHandler());// сохр-е польз-ля в **Applic-n** CSS
            server.createContext("/appl", new ApplicationListHandler());//вывод пользователей **Application**
            server.createContext("/saveperson", new SaverHandler());//добавление пользователей в **Phonebook** - 2е окно
            server.createContext("/listphonebook", new ListHandler());//вывод пользователей **Phonebook** на экран
            server.createContext("/", new PresavePersonHandler());//добавление пользователей в **Phonebook**
        } catch (IOException e) {
            e.printStackTrace();
        }
        server.setExecutor(null);
        System.out.println("Webserver starts on InetSocketAddress(9000)");

        server.start();
    }

}
