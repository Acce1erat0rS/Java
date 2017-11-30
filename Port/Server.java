import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String args[]){
        try{
            ServerSocket ss = new ServerSocket(8888);
            Socket socket = ss.accept();

            //一个Reader不够，读完了就丢了，所以要一个buffer存一下
            //从socket获得的内容叫做cin
            BufferedReader cin = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            //cout为socket的output
            PrintWriter cout = new PrintWriter(socket.getOutputStream());

            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

            String answer,ask;
            //从client读到的东西buffer在cin中
            ask = cin.readLine();
            while(!ask.equals("bye")){
                System.out.println("client ask:"+ask);
                answer = input.readLine();
                cout.println(answer);
                //要通过flush彻底写到对方
                cout.flush();
                ask = cin.readLine();
            }
            cin.close();
            socket.close();
            cout.close();
            ss.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }//main
}//class Server
