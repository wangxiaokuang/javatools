package tum0r.network;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDP {

	public boolean send(String address, int port, String data, String encode) {
		DatagramSocket socket;
		try {
			socket = new DatagramSocket();
			byte[] sendData = data.getBytes(encode);
			DatagramPacket datagramPacket = new DatagramPacket(sendData, sendData.length,
					InetAddress.getByName(address), port);
			socket.send(datagramPacket);
			socket.close();
			return true;
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public String accept(int port, int dataSize, String encode) {
		DatagramSocket socket;
		try {
			socket = new DatagramSocket(port);
			byte[] temp = new byte[dataSize];
			DatagramPacket data = new DatagramPacket(temp, temp.length);
			socket.receive(data);
			socket.close();
			return new String(new String(data.getData()).getBytes(encode));
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
