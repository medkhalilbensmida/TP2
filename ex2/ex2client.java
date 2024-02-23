package ex2;
import java.io.*;
import java.net.*;

public class ex2client {
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try {
            voiture voiture = new voiture("SUV", "Toyota");

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(voiture);
            byte[] data = outputStream.toByteArray();

            DatagramSocket socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost"); // Adresse IP du serveur
            DatagramPacket packet = new DatagramPacket(data, data.length, serverAddress, SERVER_PORT);
            socket.send(packet);

            System.out.println("Objet voiture envoyé au serveur.");

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
