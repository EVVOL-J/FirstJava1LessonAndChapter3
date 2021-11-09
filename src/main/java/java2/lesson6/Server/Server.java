package java2.lesson6.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static final int PORT=8189;
    public static void main(String[] args) {
        String message;
        try (ServerSocket serverSocket=new ServerSocket(PORT)){
            System.out.println("Сервер запущен");
            Socket clientSocket=serverSocket.accept();
            System.out.println("Клиент подключился");
            DataInputStream in=new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out=new DataOutputStream(clientSocket.getOutputStream());
            write(out);

            while (true){
                message=in.readUTF();
                System.out.println(message);
                out.writeUTF("Echo "+message);
            }




        } catch (IOException e) {
            System.out.println("Ошибка создания сервера или потеря соединения с клиентом");
        }
        System.out.println("Сервер остановлен");
    }

    private static void write(DataOutputStream out) {

        Thread thread=new Thread(() -> {
            Scanner scanner=new Scanner(System.in);
            try {

                while (true){
                if(scanner.hasNext()) out.writeUTF(scanner.nextLine()+"\n");
            }
            }catch (IOException e){
                System.out.println("Ошибка соединения");
            }

        });
        thread.setDaemon(true);
        thread.start();
    }
}
