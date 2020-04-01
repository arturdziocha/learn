package hyperskill.projects.stage6;

import java.util.List;

public class LogGateway {
    private List<String> logs;

    void add(String log) {
        this.logs.add(log);
    }

    List<String> getAll() {
        return logs;
    }
}
