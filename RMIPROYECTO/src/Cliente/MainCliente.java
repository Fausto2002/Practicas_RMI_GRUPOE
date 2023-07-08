package Cliente;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import javax.swing.JOptionPane;
import RMI.RemoteInterface;

public class MainCliente {
    public static void main (String args[]) {
        try {
            String valora = JOptionPane.showInputDialog("Ingrese el valor número Uno");
            String valorb = JOptionPane.showInputDialog("Ingrese el valor número Dos");
            int a = Integer.parseInt(valora);
            int b = Integer.parseInt(valorb);

            // Configura la propiedad java.rmi.server.hostname
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");

            Registry miRegistro = LocateRegistry.getRegistry("127.0.0.1", 1234);
            RemoteInterface s = (RemoteInterface) miRegistro.lookup("Matematicas");

            JOptionPane.showMessageDialog(null, "Resultado suma: " + s.suma(a, b));
            JOptionPane.showMessageDialog(null, "Resultado resta: " + s.resta(a, b));
            JOptionPane.showMessageDialog(null, "Resultado multiplicación: " + s.multiplica(a, b));
            JOptionPane.showMessageDialog(null, "Resultado división: " + s.division(a, b));
            JOptionPane.showMessageDialog(null,"El número " + a + " elevado a la " + b + " = " + s.potencia (a,b));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}