package com.dilloty;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;


public class Server extends AbstractVerticle {
    public void start() {
        HttpServer server = vertx.createHttpServer();
        Router router = Router.router(vertx);
        Route route = router.route().path("/hello");
        route.handler(req -> req.response()
                .putHeader("content-type", "text/plain")
                .end("Hello from Vert.x!"));
        server.requestHandler(router).listen(8088);
    }
}
