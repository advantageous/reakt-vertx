package io.advantageous.reakt.vertx;

import io.advantageous.reakt.Callback;
import io.advantageous.reakt.promise.Promise;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

public class ReaktVertx {


    /**
     * Works with both Reakt promises and Reakt callbacks
     *
     * @param promise promise
     * @param <T>     type of result
     * @return vertx handler
     */
    public static <T> Handler<AsyncResult<T>> convertPromise(final Promise<T> promise) {
        return convertCallback(promise.asHandler());
    }

    /**
     * Works with both Reakt promises and Reakt callbacks
     *
     * @param callback callback
     * @param <T>      type of result
     * @return vertx handler
     */
    public static <T> Handler<AsyncResult<T>> convertCallback(final Callback<T> callback) {
        return event -> {
            if (event.failed()) {
                callback.reject(event.cause());
            } else {
                callback.resolve(event.result());
            }
        };
    }

}
