package ex1;
import java.net.*;
import java.util.Scanner;
public class ex1client {
public static void main(String argv[]) {
int port = 0;
String host = "";
Scanner keyb = new Scanner(System.in);
try {

System.out.println("Adress du serveur : ");
host = keyb.next();
System.out.println("port d'écoute du serveur : ");
port = keyb.nextInt();
InetAddress adr;
DatagramPacket packet;
DatagramSocket socket;
adr = InetAddress.getByName(host);
byte[] data = (new String("Hello Word")).getBytes();
packet = new DatagramPacket(data, data.length, adr, port);
socket = new DatagramSocket();
socket.send(packet);
byte[] reponse = new byte[15];
packet.setData(reponse);
packet.setLength(reponse.length);
socket.receive(packet);
String chaine = new String(packet.getData(), 0,

packet.getLength());

System.out.println(" reçu du serveur : " + chaine);
} catch (Exception e) {
System.err.println("Erreur : " + e);
}
}
}