import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import  org.json.*;

public class Server {
    final int port = 20000;
    ServerSocket serverSocket;
    Server() throws Exception{
        serverSocket = new ServerSocket(port);
        System.out.println("Port "+port+" is waiting for connections");
        Socket socket = serverSocket.accept();
        System.out.println("Connected");

        InputStream inputStream = socket.getInputStream();
        StringBuffer sb = new StringBuffer();
        int intReader = -1;
        while ((char) intReader!='}')
        {
            intReader = inputStream.read();
            sb.append((char)intReader);
        }
        System.out.println(sb);
        JSONObject jsonObject = new JSONObject(sb);
        String login = jsonObject.getString("login");
        String date = jsonObject.getString("date");
        FileWriter logs = new FileWriter("ПУТЬ_К_ФАЙЛУ");
        logs.write(login+" connected at "+date);

    }

    public static void main(String[] args) {
        try {
            new Server();
            new Client();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
