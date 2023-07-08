package RMI;

import java.rmi.Remote;

public interface RemoteInterface extends Remote {
	public int suma(int x, int y) throws Exception;
	public int resta(int x, int y) throws Exception;
	public int multiplica (int x, int y) throws Exception;
	public int division(int x, int y) throws Exception;
	public int potencia (int x, int y) throws Exception; 
}
