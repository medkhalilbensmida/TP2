package ex2;
import java.io.*;
import java.net.*;

public class ex2serveur {
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(SERVER_PORT);

            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            System.out.println("Serveur en attente de données...");
            socket.receive(packet);

            ByteArrayInputStream inputStream = new ByteArrayInputStream(packet.getData());
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            voiture voiture = (voiture) objectInputStream.readObject();

            System.out.println("Voiture reçue du client:");
            System.out.println("Type: " + voiture.getType());
            System.out.println("Modèle: " + voiture.getModel());

            voiture.setCarburant(50); 
            System.out.println("Quantité de carburant après fixation: " + voiture.getCarburant());

            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
