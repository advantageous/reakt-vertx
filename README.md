# Reakt Vertx
Added Promises and simplified streaming to Vert.x

```java
final Promise<Employee> promise = Promises.<Employee>promise();
promise.thenExpect(this::handleResult).catchError(this::handleError);
/** Convert the Reakt promise to a Vert.x asyncResultHandler */
final Handler<AsyncResult<Employee>> asyncResultHandler = ReaktVertx.convertPromise(promise);
```


You can also use replay promises, all promises, any promises, and other
features of [Reakt](http://advantageous.github.io/reakt) to simplify async, reactive Vertx/Java development.


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
* [Czar Maker Consul](http://advantageous.github.io/czar-maker-consul/)
* [Czar Maker](http://advantageous.github.io/czar-maker/)
* [Reactive Microservices](http://www.mammatustech.com/reactive-microservices)
