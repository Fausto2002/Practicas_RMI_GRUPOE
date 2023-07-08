package Server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MainServer {
    public static void main(String args[]) {
        try {
            // Configura la propiedad java.rmi.server.hostname
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");

            Registry miRegistry = LocateRegistry.createRegistry(1234);
            miRegistry.rebind("Matematicas", new ServerImplements());
            System.out.println("Servidor ON");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
