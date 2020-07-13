import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;

public class Client
{
    final  String ip = "192.168.0.249";
    final  int port = 20000;
Client() throws  Exception{
    Socket socket = new Socket(ip, port);

    OutputStream outputStream =  socket.getOutputStream();
    String clientData = "";
    String login = "login";
    String pass = "password";
    String date = (new Date()).toString();
    clientData = "{\n\"login:\""+login+"\",\n\"pass\":\""+pass+"\",\n\"time\":\""+date+"\"\n}";
    for (char i : clientData.toCharArray()){
        outputStream.write(i);
    }
    outputStream.flush();
    outputStream.close();
}
}


/*
{
 "login":"login",
 "pass":"pass",
 "time":"time"
}
 */