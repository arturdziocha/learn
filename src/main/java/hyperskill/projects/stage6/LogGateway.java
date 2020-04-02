package hyperskill.projects.stage6;

import java.util.ArrayList;
import java.util.List;

public class LogGateway {
    private List<String> logs;

    public LogGateway() {
        this.logs = new ArrayList<>();
    }

    void add(String log) {
        this.logs.add(log);
    }

    List<String> getAll() {
        return logs;
    }
}
