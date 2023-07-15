package exercise.connections;

import exercise.TcpConnection;
// BEGIN
public class Disconnected implements Connection {

    private TcpConnection TcpConnection;

    public Disconnected(TcpConnection TcpConnection) {
        this.TcpConnection = TcpConnection;
    }

    @Override
    public void connect() {
        this.TcpConnection.setState(new Connected(this.TcpConnection));
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
