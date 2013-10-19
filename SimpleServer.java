import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
	public static void main(String[] args) throws IOException {
		try (ServerSocket socket = new ServerSocket(1337)) {
			while (true) {
				Socket con = socket.accept();
				InputStream inputsteam = con.getInputStream();
				byte[] buffer = new byte[120];
				while (true) {
					inputsteam.read(buffer, 0, buffer.length);
					System.out.println(new String(buffer));
				}
			}
		}
	}
}
