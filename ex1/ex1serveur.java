package ex1;
import java.net.*;
import java.util.Scanner;
public class ex1serveur {
public static void main(String argv[]) {
int port = 0;
Scanner keyb = new Scanner(System.in);
try {
System.out.println("port d'écoute : ");
port = keyb.nextInt();
DatagramPacket packet;
DatagramSocket socket = new DatagramSocket(port);
byte[] data = new byte[15];
packet = new DatagramPacket(data, data.length);
socket.receive(packet);
String chaine = new String(packet.getData(), 0,
packet.getLength());
System.out.println(" recu : " + chaine);
System.out.println(" ca vient de : " + packet.getAddress() + ":" +
packet.getPort());
byte[] reponse = (new String("bien recu")).getBytes();
packet.setData(reponse);
packet.setLength(reponse.length);
socket.send(packet);
} catch (Exception e) {
System.err.println("Erreur : " + e);
}
}
}