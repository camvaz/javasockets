package testsocket;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import testsocket.Conexion;

public class Cliente extends Conexion {
     public Cliente() throws IOException{super("cliente");} //Se usa el constructor para cliente de Conexion
 
     public String startClient(String Mensaje) //Método para iniciar el cliente
     {
    	 String msj = "";
         try
         {
              //Flujo de datos hacia el servidor
	          OutputStream os = cs.getOutputStream();
	          OutputStreamWriter osw = new OutputStreamWriter(os);
	          BufferedWriter bw = new BufferedWriter(osw);
              //Se enviarán dos mensajes
              bw.write("Cliente");
              bw.write("\n"+Mensaje);
              bw.flush();
            
              cs.close();//Fin de la conexión
         }
          catch (Exception e)
          {
             System.out.println(e.getMessage());
          }
         return msj;
      }
  }

