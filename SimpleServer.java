import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 *  @author	Jan <jan1337z> Meier
 */
public class SimpleServer {
	public static void main(String[] args) throws IOException {
		try (ServerSocket socket = new ServerSocket(1337)) {
			System.out.println("By Jan1337z @ GitHub ");
			System.out.println("Starting server...");
			while (true) {
				System.out.println("Awaiting connection...");
				Socket con = socket.accept();
				System.out.println("Connection accpeted...");
				InputStream inputsteam = con.getInputStream();
				byte[] buffer = new byte[120];
				while ((inputsteam.read(buffer, 0, buffer.length)) >= 0) {
					System.out.format("received:\t %s \n", new String(buffer));
				}
				System.out.println("Connection lost...");
			}
		} finally {
			System.out.println("Server error...");
		}
	}
}
