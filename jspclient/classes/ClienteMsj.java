package testsocket;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import testsocket.Conexion;

public class ClienteMsj extends Conexion {
     public ClienteMsj() throws IOException{super("clientemsj");} //Se usa el constructor para cliente de Conexion
 
     public String startClient() //Método para iniciar el cliente
     {
    	 String msj = "";
         try
         {

             OutputStream os = cs.getOutputStream();
             OutputStreamWriter osw = new OutputStreamWriter(os);
             BufferedWriter bw = new BufferedWriter(osw);
             
             bw.write("Cliente2");
             bw.write("\nmemes");
             bw.flush();   
             
             InputStream is = cs.getInputStream();
             InputStreamReader isr = new InputStreamReader(is);
             BufferedReader br = new BufferedReader(isr);
             String message = br.readLine();
 
             msj+=message;
             
             cs.close();//Fin de la conexión
         }
          catch (Exception e)
          {
             System.out.println(e.getMessage());
          }
         return msj;
      }
  }

