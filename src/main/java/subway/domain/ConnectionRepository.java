package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class ConnectionRepository {

    private static List<Connection> connections = new ArrayList<>();

    public static void addConnection(Connection connection) {
        connections.add(connection);
        connections.add(connection.getReverse());
    }

    public static List<Connection> connections() {
        return connections;
    }
}
