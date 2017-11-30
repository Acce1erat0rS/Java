import javax.xml.stream.events.Characters;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Receiver{
    public static void main(String[] args){
        LineReceiver lr = new LineReceiver(new CharReceiver(6102));
        String pattern = args[0];
        //String pattern = "wz";
        int count = lr.receivePattern(pattern);
        System.out.println("共收到模式串 " + pattern + " " + count + " 次");
    }
}

class CharReceiver {
    DatagramSocket socketReceiver = null;
    public CharReceiver(int port){
        try{
            socketReceiver = new DatagramSocket(port);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public char receive(){
        try{
            byte[] recvBuf = new byte[10];
            DatagramPacket dp = new DatagramPacket(recvBuf,recvBuf.length);
            socketReceiver.receive(dp);
            String recvStr = new String(dp.getData() , 0 ,dp.getLength());
            System.out.println("收到:" + recvStr);
            return recvStr.charAt(0);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return '0';
    }
}

class LineReceiver {
    private CharReceiver cr = null;
    private char[] charBuf = new char[10];

    public LineReceiver(CharReceiver cr){
        this.cr = cr;
    }


    public String receiveLine(){
        char c = cr.receive();
        int i = 0;
        if(c == '@'){
            return "";
        }
        while (c!='#'){
            charBuf[i++] = c;
            c = cr.receive();
        }
        String str = String.valueOf(charBuf,0,i);
        return str;
    }

    public int receivePattern(String pattern){
        String s = this.receiveLine();
        int count = 0;
        s.trim();
        count+=matchPattern(s,pattern);
        while(s.length()>0)
        {
            s = this.receiveLine();
            s.trim();
            count+=matchPattern(s,pattern);
        }
        return count;
    }

    public static int matchPattern(String matrix, String pattern){
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(matrix);
        int count = 0;
        while(m.find()){
            count++;
        }

        System.out.println("所获得字符串为:"+matrix+" 匹配模式为:"+pattern+" 匹配结果:"+count);
        return count;
    }
}
