package tvn_ltmmt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class Server {

    public static final char SPACE = ' ';
    public static final char TAB = '\t';
    public static final char BREAK_LINE = '\n';
    public final static int SERVER_PORT = 7;
    public static String dem = "";  
    public static String viTri = "";

    public String mahoa(String br, int k) {
        String kq = "";
        int n = br.length();
        for (int i = 0; i < n; i++) {
            kq += mahoakt(br.charAt(i), k);
        }
        return kq;
    }

    char mahoakt(char c, int k) {
        if (!Character.isLetter(c)) return c;
        return (char) ((((Character.toUpperCase(c) - 'A') + k) % 26 + 26) % 26 + 'A');
    }

    public static int countWords(String input) {
        if (input == null) {
            return -1;
        }
        int count = 0;
        int size = input.length();
        boolean notCounted = true;
        for (int i = 0; i < size; i++) {
            if (input.charAt(i) != SPACE && input.charAt(i) != TAB 
                    && input.charAt(i) != BREAK_LINE) {
                if(notCounted) {
                    count++;
                    notCounted = false;
                }
            } else {
                notCounted = true;
            }
        }
        return count;
    }
    
    static void DemKyTu(String str, String soLanXuatHien, String kyTu)
    {
        int counter[] = new int[256];
        int len = str.length();
        for (int i = 0; i < len; i++)
            counter[str.charAt(i)]++;
        char array[] = new char[str.length()];
        for (int i = 0; i < len; i++) {
            array[i] = str.charAt(i);
            int flag = 0;
            for (int j = 0; j <= i; j++) {
                if (str.charAt(i) == array[j])
                    flag++;
            }
            if (flag == 1) {
                dem = dem + String.valueOf(str.charAt(i));
                viTri = viTri + String.valueOf(counter[str.charAt(i)]);
            }            
        }
    }
    
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        String rs = null;
        int key = 0;
        
        
        try {
            System.out.println("Binding to port " + SERVER_PORT + ", please wait  ...");
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server started: " + serverSocket);
            System.out.println("Waiting for a client ...");
            while (true) {
                try {
                    Socket client = serverSocket.accept();
                    System.out.println("Client accepted: " + client);
                    DataInputStream din = new DataInputStream(client.getInputStream());
                    DataOutputStream dout = new DataOutputStream(client.getOutputStream());
                    int flag = din.readInt();
                    if (flag == 1) {
                        System.out.println("--------------------SEND SERVER--------------------");
                        int k = din.readInt();
                        key = k;
                        System.out.println(k);
                        int lenghtn = din.readInt();
                        byte[] data = new byte[lenghtn];
                        din.readFully(data);
                        String str = new String(data, "UTF-8");
                        rs = str;
                        System.out.println(str);      
                    } else if (flag == 2){
                        System.out.println("--------------------DECRYPT--------------------");
                        Server echo = new Server();
                        String kq = echo.mahoa(rs, -key);
                        System.out.println(kq);
                        byte[] data1 = kq.getBytes("UTF-8");
                        dout.writeInt(data1.length);
                        dout.write(data1);        
                    } else {
                        System.out.println("--------------------WORD COUNT--------------------");
                        Server echo = new Server();
                        String kq = echo.mahoa(rs, -key);
                        System.out.println("Total words: " + countWords(kq)); 
                        DemKyTu(kq, dem, viTri);   
                        byte[] data1 = dem.getBytes("UTF-8");
                        dout.writeInt(data1.length);
                        dout.write(data1);
                        byte[] data2 = viTri.getBytes("UTF-8");
                        dout.writeInt(data2.length);
                        dout.write(data2);
                        System.out.println("The number of occurrences in char: " + "\n" + dem + "\n" + viTri);
                    }
                } catch (IOException e) {
                    System.err.println(" Connection Error: " + e);
                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}
