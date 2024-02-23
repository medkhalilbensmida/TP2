package ex3;
import java.io.*;
import java.net.*;
import java.util.*;

public class ex3serveur {
    private static final int SERVER_PORT = 1250;

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(SERVER_PORT);

            System.out.println("Serveur UDP en attente sur le port " + SERVER_PORT + "...");

            while (true) {
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                socket.receive(packet);

                InetAddress clientAddress = packet.getAddress();
                int clientPort = packet.getPort();

                String dateTime = new Date().toString();

                byte[] data = dateTime.getBytes();

                DatagramPacket responsePacket = new DatagramPacket(data, data.length, clientAddress, clientPort);

                socket.send(responsePacket);

                System.out.println("Datagramme envoyé à " + clientAddress + ":" + clientPort);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}