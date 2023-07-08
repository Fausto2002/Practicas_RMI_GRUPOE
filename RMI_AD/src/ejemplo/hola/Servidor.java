package ejemplo.hola;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor implements Hola {
	public Servidor() {}
	public String diHola(){
		return "Hola, mundo";
	}
	public static void main(String args[]){
		try {
			String ip = "192.168.56.1";
            System.setProperty("java.rmi.server.hostname", ip);
            
            Registry registro = LocateRegistry.createRegistry(1099);

			Servidor obj = new Servidor();
			Hola stub = (Hola) UnicastRemoteObject.exportObject(obj, 0);

	
			// Liga los datos (stub) del objeto remoto en el registro
			registro.bind("Hola",stub);
			System.err.println("Servidor listo");
		} catch (Exception e) {
			System.err.println("Excepción del servidor: " + e.toString());
			e.printStackTrace();
		}  
	}  
}
