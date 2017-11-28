import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String args[]){
        try{
            Socket socket = new Socket("127.0.0.1",8888);
            BufferedReader sin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter sout = new PrintWriter(socket.getOutputStream());
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            String ask = input.readLine();
            while(!ask.equals("end")){
                sout.println(ask);
                sout.flush();
                System.out.println();
                ask = input.readLine();
            }
            sin.close();
            sout.close();
            socket.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
