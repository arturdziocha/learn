package snippets.streams;

import java.util.Optional;
import java.util.function.Consumer;

public class OptionalConsumer {
    public static <T> void ifPresentOrElse(Optional<T> optional, Consumer<? super T> action, Runnable emptyAction) {
        if (optional.isPresent()) {
            action.accept(optional.get());
        } else {
            emptyAction.run();
        }
    }
}
