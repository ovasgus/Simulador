import java.rmi.*;
import java.net.MalformedURLException;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;

/**
 *
 * @author gustavo
 */
public class commit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String host = null;
        int port = 0;

        if (args.length != 8) {
            System.err.print("Parametros incorrectos: ");
            System.err.println("java commit -dns <hostDNS> -r <repositorio> -u <User> -p <PathArchivos>");
            System.exit(1);
        }
        

        try {
           
            
            // BUSCAR LOS ARCHIVOS Y ENCRIPTARLOS
            ArrayList<File> archivos = new ArrayList<File>();
            String repo = args[3];
            String nombre = args[5];
            host = args[1];
            Date hora = new Date();
       
       
        /**Primero nos conectamos con el DNS*/
            DNSI d = (DNSI) Naming.lookup("rmi://" + host + ":" + 44444 + "/DNS");
            Servidor serv = d.quienEsCoord();
            
            
        // Antes de todo revizamos que este la carpeta del repo en nuestro
            // directorio
            File f1 = new File(args[7]);

            if(!f1.exists()){

                System.out.println("Directorio:  \""+args[7]+"\" no encontrado...");
                System.exit(0);
            }
            
//             PublicKey llave = serer.getPublica();
//             File temporal = new(File("./temporalEncriptado"));  
        File[] listOfFiles = f1.listFiles(); 

        ArrayList<File> archivitos = new ArrayList<File>();




//      String tmp = "";
        
        for (int i = 0; i < listOfFiles.length; i++){
            if (listOfFiles[i].isFile()){
                archivitos.add(listOfFiles[i]);

            }            
        }
        
            Actualizacion a = new Actualizacion("commit",nombre,repo,archivitos,hora);
          
            /**Luego buscamos el servicio como tal*/
            Acciones c = (Acciones) Naming.lookup("rmi://" + serv.getHost() + ":" + 55555 + "/REPO");
            System.out.println(c.commit(a));
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
