package ex3;
import java.io.*;
import java.net.*;

public class ex3client {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 1250;

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();

            byte[] sendData = new byte[0];

            InetAddress serverAddress = InetAddress.getByName(SERVER_IP);
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, SERVER_PORT);
            socket.send(sendPacket);

            System.out.println("Datagramme envoyé au serveur sur le port " + SERVER_PORT);

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);

            String dateTime = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Réponse du serveur: " + dateTime);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
