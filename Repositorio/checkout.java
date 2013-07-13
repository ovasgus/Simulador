import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author gustavo
 */
public class checkout {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String host = null;
        int tam = 0;

//         if (!((0 < args.length) && (args.length < 4))) {
//             System.err.print("Parametros incorrectos: ");
//             System.err.println("CalculatorClient <hostName> <port>");
//             System.exit(1);
//         }

        try {
            tam = args.length;
            host = args[0];
            

            // Busca al objeto que ofrece el servicio con nombre 
            // CalculatorService en el Registry que se encuentra en
            // el host <host> y puerto <port>

            Acciones c = (Acciones) Naming.lookup("rmi://" + host + ":" + 55555 + "/CalculatorService");
            //System.out.println(c.checkout());
        } catch (MalformedURLException murle) {
            System.out.println();
            System.out.println(
                    "MalformedURLException");
            System.out.println(murle);
        } catch (RemoteException re) {
            System.out.println();
            System.out.println(
                    "RemoteException");
            System.out.println(re);
        } catch (NotBoundException nbe) {
            System.out.println();
            System.out.println(
                    "NotBoundException");
            System.out.println(nbe);

        } catch (Exception e) {
            System.out.println();
            System.out.println("java.lang.Exception");
            System.out.println(e);
        }
    }
}