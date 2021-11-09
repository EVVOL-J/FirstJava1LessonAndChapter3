package java2.lesson6.client;

import javafx.application.Platform;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Network {
    private static final int PORT=8189;
    private static final String ADDRESS ="localhost";
    private DataInputStream in;
    private DataOutputStream out;
    private final int port;
    private final String address;

    Network(){
        this(PORT,ADDRESS);
    }

    Network(int port, String address){
        this.port=port;
        this.address=address;
    }




    public boolean connect(){
        try {
            Socket socket = new Socket(address, port);
            this.in=new DataInputStream(socket.getInputStream());
            this.out=new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            Client.showNetworkError("Ошибка подключения к серверу","Сервер не запущен");
           return false;
        }
        return true;
    }

    public boolean write(String message){
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            Client.showNetworkError("Ошибка отвпрвки сообщения", "Сервер упал");
            return false;
        }
        return true;
    }
    public void read(Controller controller){
        Thread thread=new Thread(() -> {
            try {
                while (true){
                String message=in.readUTF();
                    Platform.runLater(()-> controller.appendMessage(message));

            } }catch (IOException e){

                Client.showNetworkError("Потеря соединения", "Сервер упал");
            }

        });
        thread.setDaemon(true);
        thread.start();

    }

}
