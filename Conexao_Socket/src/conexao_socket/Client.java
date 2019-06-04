import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		try {
            Socket socket = new Socket("127.0.0.1", 2607);
            System.out.println("Conectando com a porta e servidor ...");
            
            DataInputStream data_input = new DataInputStream(socket.getInputStream());
            DataOutputStream data_output = new DataOutputStream(socket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            String msg_entrada = "";
            String msg_saida = "";
            
            while (!msg_entrada.toLowerCase().equals("sair")) {
                msg_saida= br.readLine();
                data_output.writeUTF(msg_saida);
                data_output.flush();
                msg_entrada = data_input.readUTF();
                System.out.println(msg_entrada);
            }
            
        	
		}catch(Exception e){
			//handle exceptions here
		}

	}

}
