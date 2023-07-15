package exercise.connections;

import exercise.TcpConnection;
// BEGIN
public class Disconnected implements Connection {

    private TcpConnection tcpConnection;

    public Disconnected(TcpConnection TcpConnection) {
        this.tcpConnection = tcpConnection;
    }

    @Override
    public void connect() {
        this.tcpConnection.setState(new Connected(this.tcpConnection));
        System.out.println("Connection is established.");
    }

    @Override
    public void disconnect() {
        System.out.println("Error! Connection is already disconnected.");
    }

    @Override
    public String getCurrentState() {
        return "disconnected";
    }
}
// END
