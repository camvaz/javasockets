import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Conexion{ 
    public String mensajes;

    public Servidor() throws IOException{super("servidor"); this.mensajes = "";}  
    public String getMensajes() {return this.mensajes;}

    public void startServer(){

        try{
            while(true) {

                System.out.println("Esperando...");                    //Esperando conexión
                cs = ss.accept(); 
                //Start the socket, Read from inputstream

                System.out.println("Cliente en línea");
                BufferedReader entrada = new BufferedReader(new InputStreamReader(cs.getInputStream()));
               
                if((mensajeServidor = entrada.readLine()) != null 
                        && mensajeServidor.contentEquals("Cliente")) {
                    while((mensajeServidor = entrada.readLine()) != null){ 
                        

                        this.mensajes+=mensajeServidor+" ";
                        System.out.println(mensajeServidor);
                    }

                    System.out.println("Fin de la conexión");

                } else { //For the JSP Ledger
                    System.out.println("Opc2");
                    System.out.println(this.mensajes);
                    OutputStream os = cs.getOutputStream();
                    OutputStreamWriter osw = new OutputStreamWriter(os);
                    BufferedWriter bw = new BufferedWriter(osw);
                    bw.write(this.mensajes);
                    bw.flush();

                }

            }
        } catch (Exception e){
            System.out.println("Excepcion: " + e.getMessage());
        } finally {
            try {
                ss.close();
            }catch(IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
