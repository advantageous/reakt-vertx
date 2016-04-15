# Reakt Vertx
Added Promises and simplified streaming to Vert.x.
Check out the [Reakt Vertx Website](http://advantageous.github.io/reakt-vertx).


```java
final Promise<Employee> promise = Promises.<Employee>promise();
promise.thenExpect(this::handleResult).catchError(this::handleError);
/** Convert the Reakt promise to a Vert.x asyncResultHandler */
final Handler<AsyncResult<Employee>> asyncResultHandler = ReaktVertx.convertPromise(promise);
```


You can also use replay promises, all promises, any promises, and other
features of [Reakt](http://advantageous.github.io/reakt) to simplify async, reactive Vertx/Java development.

You can see a [Vert.x event bus example in the wiki](https://github.com/advantageous/reakt-vertx/wiki/Reakt-Vertx-in-Action). If you are new to Reakt,
stop by [Reakt Website](http://advantageous.github.io/reakt) and the [Reakt Wiki](https://github.com/advantageous/reakt/wiki) to learn more about Reakt promises.


## Getting Started
#### maven
```xml
<dependency>
    <groupId>io.advantageous.reakt</groupId>
    <artifactId>reakt-vertx</artifactId>
    <version>2.1.0.RELEASE</version>
</dependency>
```

#### gradle
```java
compile 'io.advantageous.reakt:reakt-vertx:2.1.0.RELEASE'
```

[Reakt](http://advantageous.github.io/reakt) gets used by [QBit](http://advantageous.github.io/qbit/), and Conekt.

[Reakt Vertx Website](http://advantageous.github.io/reakt-vertx)

#### Related projects
* [QBit Reactive Microservices](http://advantageous.github.io/qbit/)
* [Reakt Reactive Java](http://advantageous.github.io/reakt)
* [Reakt Guava Bridge](http://advantageous.github.io/reakt-guava/)
* [QBit Extensions](https://github.com/advantageous/qbit-extensions)
* [Elekt Consul](http://advantageous.github.io/elekt-consul/)
* [Elekt](http://advantageous.github.io/elekt/)
* [Reactive Microservices](http://www.mammatustech.com/reactive-microservices)
