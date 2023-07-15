package exercise;
import exercise.connections.Connection;
import exercise.connections.Disconnected;
import exercise.connections.Connected;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

// BEGIN
public class TcpConnection {

    private String ip;
    private int port;
    private Connection connectionState;
    private List<String> buffer = new ArrayList<>();

    public TcpConnection(String ip, int port) {
        this.ip = ip;
        this.port = port;
        //соединение по умолчанию disconnected
        this.connectionState = new Disconnected(this);
    }

    //возвращает текущее состояние в виде строки
    @Override
    public String getCurrentState() {
        return this.connectionState.getCurrentState();
    }

    @Override
    public void setState(Connection connectionState) {
        this.connectionState = connectionState;
    }

    //устанавливает новое соединение
    @Override
    public void connect() {
        this.connectionState.connect();
    }
    //разрывает установленное соединение
    @Override
    public void disconnect() {
        this.connectionState.disconnect();connect();
    }

    //добавляет текстовые данные в буфер
    @Override
    public void write(String data) {
        if (Objects.equals(this.connectionState.getCurrentState(), "connected")) {
            this.buffer.add(data);
        } else {
            System.out.println("Error! Cannot writ data. Connection firstly should be established.");
        }
    }

}
// END
