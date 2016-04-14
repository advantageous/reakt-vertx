package io.advantageous.reakt.vertx;

import io.advantageous.reakt.Expected;
import io.advantageous.reakt.promise.Promise;
import io.advantageous.reakt.promise.Promises;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ReaktVertxTest {

    public static class Employee {
        private final String id;

        public Employee(String id) {
            this.id = id;
        }
    }

    @Test
    public void testConvertPromiseSuccess() throws Exception {

        AtomicReference<Expected<Employee>> ref = new AtomicReference<>();
        Promise<Employee> promise = Promises.<Employee>promise();
        promise.thenExpect(ref::set);
        final Handler<AsyncResult<Employee>> asyncResultHandler = ReaktVertx.convertPromise(promise);

        AsyncResult<Employee> asyncResult = new AsyncResult<Employee>() {
            @Override
            public Employee result() {
                return new Employee("Bob");
            }

            @Override
            public Throwable cause() {
                return null;
            }

            @Override
            public boolean succeeded() {
                return true;
            }

            @Override
            public boolean failed() {
                return false;
            }
        };


        asyncResultHandler.handle(asyncResult);


        assertTrue(promise.complete());
        assertTrue(promise.success());
        assertNotNull(promise.get());
        assertEquals("Bob", promise.get().id);
        assertNotNull(ref.get());
        assertTrue(ref.get().isPresent());
        assertEquals("Bob", ref.get().get().id);
    }


    @Test
    public void testConvertPromiseFailure() throws Exception {

        AtomicReference<Throwable> ref = new AtomicReference<>();
        Promise<Employee> promise = Promises.<Employee>promise();
        promise.catchError(ref::set);
        final Handler<AsyncResult<Employee>> asyncResultHandler = ReaktVertx.convertPromise(promise);

        AsyncResult<Employee> asyncResult = new AsyncResult<Employee>() {
            @Override
            public Employee result() {
                return null;
            }

            @Override
            public Throwable cause() {
                return new Exception("bad stuff");
            }

            @Override
            public boolean succeeded() {
                return false;
            }

            @Override
            public boolean failed() {
                return true;
            }
        };


        asyncResultHandler.handle(asyncResult);


        assertTrue(promise.complete());
        assertTrue(promise.failure());
        assertNotNull(promise.cause());
        assertNotNull(ref.get());
        assertEquals("bad stuff", promise.cause().getMessage());
        assertEquals("bad stuff", ref.get().getMessage());
    }
}