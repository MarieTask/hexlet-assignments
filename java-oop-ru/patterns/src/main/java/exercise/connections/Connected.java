package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Connected implements Connection {

    private TcpConnection TcpConnection;

    public Connected(TcpConnection TcpConnection) {
        this.TcpConnection = TcpConnection;
    }

    @Override
    public void connect() {
        System.out.println("Error! Connection is already established.");
    }

    @Override
    public void disconnect() {
        this.TcpConnection.setState(new Disconnected(this.TcpConnection));
        System.out.println("Connection is disconnected.");
    }

    @Override
    public String getCurrentState() {
        return "connected";
    }
}
// END
