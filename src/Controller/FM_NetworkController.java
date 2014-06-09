package Controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import Model.FM_Model;

public class FM_NetworkController {

	public static final int ENEMY_WON = -1;
	public static final int I_WON = -1;
	private FM_Model _model;
	private String _host;
	private DataInputStream _fromServer;
	private DataOutputStream _toServer;
	private boolean _firstInput;

	public FM_NetworkController(FM_Model m) {
		_model = m;
		init();
	}

	public void init() {
		_host = "localhost";
		_firstInput = true;
	}
	
	public void setServer(String host) {
		_host = host;
	}

	private void connectToServer() {
		try {
			// Create a socket to connect to the server
			Socket socket = new Socket(_host, 8000);;

			// Create an input stream to receive data from the server
			_fromServer = new DataInputStream(socket.getInputStream());

			// Create an output stream to send data to the server
			_toServer = new DataOutputStream(socket.getOutputStream());
		}
		catch (Exception ex) {
			System.err.println(ex);
		}
	}

	/** Receive info from the server */
	public void receiveInfoFromServer() throws IOException {
		// Receive game status
		int status = _fromServer.readInt();

		if (_firstInput) {
			_model.setEnemyCode(status);
		} else if (status == ENEMY_WON) {
			_model.done(true, _model.ENEMY);
		} else {
			_model.updateField(_model.RIGHT, status);
		}
		
	}
	
	/** Send info to the server */
	public void sendInfoToServer(int code) throws IOException {
		_toServer.writeInt(code);
	}
}
