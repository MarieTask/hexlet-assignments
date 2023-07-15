package exercise;
import exercise.connections.Connection;
import exercise.connections.Disconnected;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

// BEGIN
public class TcpConnection {

    private String ip;
    private int port;
    private Connection connectionState ;
    private List<String> buffer = new ArrayList<>();

    public TcpConnection(String ip, int port) {
        this.ip = ip;
        this.port = port;
        //соединение по умолчанию disconnected
        this.connectionState = new Disconnected(this);
    }

    public void setState(Connection connectionState) {
        this.connectionState = connectionState;
    }

    //возвращает текущее состояние в виде строки

    public String getCurrentState() {
        return this.connectionState.getCurrentState();
    }

    //устанавливает новое соединение

    public void connect() {
        this.connectionState.connect();
    }
    //разрывает установленное соединение

    public void disconnect() {
        this.connectionState.disconnect();
    }

    //добавляет текстовые данные в буфер

    public void write(String data) {
        if (Objects.equals(this.connectionState.getCurrentState(), "connected")) {
            this.buffer.add(data);
        } else {
            System.out.println("Error! Cannot writ data. Connection firstly should be established.");
        }
    }
}
// END
