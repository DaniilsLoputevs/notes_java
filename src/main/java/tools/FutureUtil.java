package tools;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

public final class FutureUtil {
    /* For Stream API */
    public static <T> Function<CompletableFuture<T>, T> getByTimeout(long timeout, TimeUnit timeUnit) {
        return future -> getByTimeout(future, timeout, timeUnit);
    }

    /**
     * Для Красоты и использования внутри лямбдах.
     *
     * @return result || throw RuntimeException(nestedException)
     */
    public static <T> T getByTimeout(CompletableFuture<T> future, long timeout, TimeUnit timeUnit) {
        return getByTimeout(future, timeout, timeUnit, null);
    }

    public static <T> T getByTimeout(CompletableFuture<T> future, long timeout, TimeUnit timeUnit,
                                     Function<TimeoutException, T> onTimeoutFail) {
        try {
            return future.get(timeout, timeUnit);
        } catch (TimeoutException e) {
            if (onTimeoutFail != null) return onTimeoutFail.apply(e);
            else throw new RuntimeException(e);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
