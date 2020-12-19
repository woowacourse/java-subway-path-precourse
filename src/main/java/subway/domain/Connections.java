package subway.domain;

import java.util.HashSet;
import java.util.Set;

public class Connections {

    private static Set<Connection> connectionSet = new HashSet<>();

    public static void addConnection(Connection connection) {
        connectionSet.add(connection);
        connectionSet.add(connection.getReverse());
    }

    public Set<Connection> getConnections() {
        return connectionSet;
    }
}
