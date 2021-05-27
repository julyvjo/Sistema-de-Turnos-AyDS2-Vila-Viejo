package negocio;

import java.io.ObjectOutputStream;
import java.net.Socket;
import dominio.Turno;

public class ServerSocketPublicacion { //desde esta clase se envian los turnos a la componente de publicación (el socket NO escucha, solo comunica)
	
	public void publicarTurno(Turno turno) {
		
		try {
			int puerto_publicacion = Controller.getInstance().getPort_publicacion();
			
			Socket socket = new Socket("localhost",puerto_publicacion);
			
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			output.writeObject(turno);
			
			output.close();
			socket.close();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
}
