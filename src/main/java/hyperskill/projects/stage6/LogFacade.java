package hyperskill.projects.stage6;

import java.util.List;

class LogFacade {
    private final LogGateway logGateway;
    public LogFacade() {
        this.logGateway = new LogGateway();
    }
    void add(String log) {
         logGateway.add(log);
    }

    List<String> getAll() {
        return logGateway.getAll();
    }
}
