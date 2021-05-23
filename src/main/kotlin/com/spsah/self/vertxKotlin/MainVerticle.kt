package com.spsah.self.vertxKotlin

import io.vertx.core.AbstractVerticle
import io.vertx.core.Promise
import io.vertx.core.Vertx

class MainVerticle : AbstractVerticle() {

  companion object {
    @JvmStatic fun main(args: Array<String>) {
      val v = Vertx.vertx()
      v.deployVerticle(MainVerticle())
      println("OLD HELLO")
    }
  }

  override fun start(startPromise: Promise<Void>) {
    println("HELLO " + "AND HELLO")
    vertx
      .createHttpServer()
      .requestHandler { req ->
        req.response()
          .putHeader("content-type", "text/plain")
          .end("Hello from ssss server.x!")
      }
      .listen(8888) { http ->
        if (http.succeeded()) {
          startPromise.complete()
          println("HTTP server started on port 8888")
        } else {
          startPromise.fail(http.cause());
        }
      }
  }
}
