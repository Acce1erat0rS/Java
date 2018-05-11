//
// 通过Fernflower反编译的Send类，用于改一下端口
//

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

public class mSend {
    private static final Random random = new Random(47L);
    private static final int COUNT = 30;
    private static final char[] table = "uvwxyz".toCharArray();
    private static final int SLEEP_MILS = 100;
    private static final int PORT = 6102;

    public mSend() {
    }

    public static void main(String[] var0) {
        try {
            DatagramSocket var1 = new DatagramSocket();
            InetAddress var2 = InetAddress.getByName("47.95.5.97");

            for(int var3 = 0; var3 < 30; ++var3) {
                int var4 = random.nextInt(5) + 5;

                for(int var5 = 0; var5 < var4; ++var5) {
                    int var6 = random.nextInt(6);
                    char var7 = table[var6];
                    sendChar(var1, var2, 16102, var7, 100);
                }

                sendChar(var1, var2, 16102, '#', 100);
            }

            sendChar(var1, var2, 16102, '@', 100);
        } catch (Exception var8) {
            System.out.println(var8);
        }

    }

    private static final boolean sendChar(DatagramSocket var0, InetAddress var1, int var2, char var3, int var4) {
        String var5 = "" + var3;

        try {
            byte[] var6 = var5.getBytes();
            DatagramPacket var7 = new DatagramPacket(var6, var6.length, var1, var2);
            var0.send(var7);
            System.out.println("Sending   " + var5);
            Thread.sleep((long)var4);
            return true;
        } catch (Exception var8) {
            return false;
        }
    }
}
