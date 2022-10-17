package tvn_ltmmt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ProcessBuilder.Redirect.Type;
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
    public static char tam1;
    
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
    
    public static void DemKyTu(String str, String soLanXuatHien, String kyTu)
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
                viTri = viTri + String.valueOf(str.charAt(i));
                dem = dem + String.valueOf(counter[str.charAt(i)]);
            }            
        }
    }
    
    public  static byte[] toBytes(char[] chars) {
        byte[] bytes = new byte[chars.length * 2];
        int ci, bi;
        char ch;

        bi = 0;
        for (ci = 0; ci < chars.length; ++ci) {
            ch = chars[ci];
            bytes[bi++] = (byte)((ch & 0xFF00) >> 8);
            bytes[bi++] = (byte)(ch & 0x00FF);
        }

        return bytes;
    }
    
    public static char[] swap(String str, int a, int b)
    {
        char ch[] = str.toCharArray();
        char temp = ch[a];
        ch[a] = ch[b];
        ch[b] = temp;
        return ch;
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
                    } else if (flag == 3){
                        System.out.println("--------------------WORD COUNT--------------------");
                        Server echo = new Server();
                        String kq = echo.mahoa(rs, -key);
                        System.out.println("Total words: " + countWords(kq)); 
                        DemKyTu(kq, viTri, dem);   
                        byte[] data1 = viTri.getBytes("UTF-8");
                        dout.writeInt(data1.length);
                        dout.write(data1);
                        byte[] data2 = dem.getBytes("UTF-8");
                        dout.writeInt(data2.length);
                        dout.write(data2);
                        System.out.println("The number of occurrences in char: " + "\n" + dem + "\n" + viTri);
                    } else {
                        System.out.println("--------------------SWAP--------------------");
                        Server echo = new Server(); //Kết nối với Server
                        String kq = echo.mahoa(rs, -key); //Giải mã
                        System.out.println(kq); //In kết quả đã giải mã
                        int n = kq.length(); //Lấy chiều dài của bản rõ vừa được giải mã
                        System.out.println(swap(kq, 0, n - 1)); //In kết quả đã hoán vị ở console Server
                        char[] s = swap(kq, 0, n - 1); //Gán kết quả cho biến s
                        byte[] data2 = toBytes(s); //toBytes dùng để ép chuỗi từ kiểu Char về kiểu Byte
                        dout.writeInt(data2.length); //Ghi độ dài của chuỗi để gửi về Client
                        dout.write(data2); //Ghi nội dung của chuỗi gửi về Client
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
