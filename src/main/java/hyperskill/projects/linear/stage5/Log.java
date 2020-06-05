package hyperskill.projects.linear.stage5;

import java.util.ArrayList;
import java.util.List;

public class Log {
    private List<String> log = new ArrayList<>();

    public void write(String string) {
        log.add(string);
    }

    public List<String> getLog() {
        return log;
    }
}
