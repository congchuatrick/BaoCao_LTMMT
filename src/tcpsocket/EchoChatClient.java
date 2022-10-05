package tcpsocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

//Các bước tổng quát xây dựng một chương trình Client – Server ở chế độ có nối kết như sau:
//    Mở một socket nối kết đến server đã biết địa chỉ IP (hay tên miền) và số hiệu cổng.
//    Lấy InputStream và OutputStream gán với Socket.
//    Tham khảo Protocol của dịch vụ để định dạng đúng dữ liệu trao đổi với Server.
//    Trao đổi dữ liệu với Server nhờ vào các InputStream và OutputStream.
//    Đóng Socket trước khi kết thúc chương trình.

public class EchoChatClient {
	public final static String SERVER_IP = "127.0.0.1"; //Địa chỉ IP là 127.0.0.1
	public final static int SERVER_PORT = 7; //Có giả trị từ 0 ..65535

	public static void main(String[] args) throws IOException, InterruptedException {
		Socket socket = null;
		try {
			socket = new Socket(SERVER_IP, SERVER_PORT); //Kết nối đến server
			System.out.println("Connected: " + socket);

			InputStream is = socket.getInputStream(); //Nhận dữ liệu từ Server trả về
			OutputStream os = socket.getOutputStream(); //Gửi dữ liệu lên Server
			for (int i = '0'; i <= '9'; i++) {
				os.write(i); //Gửi từng số đến máy chủ
				int ch = is.read(); //Chờ kết quả trả về từ server
				System.out.print((char) ch + " "); //Hiển thị kết quả nhận được từ server
				Thread.sleep(200); //Tạm dừng thực thi luồng hiện tại trong 200 mili giây
			}
		} catch (IOException ie) {
			System.out.println("Can't connect to server");
		} finally {
			if (socket != null) {
				socket.close();
			}
		}
	}
}
