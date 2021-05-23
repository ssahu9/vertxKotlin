package com.spsah.self.vertxKotlin.eventloop

import io.vertx.core.AbstractVerticle
import io.vertx.core.DeploymentOptions
import io.vertx.core.Promise
import io.vertx.core.Vertx
import io.vertx.core.impl.logging.Logger
import io.vertx.core.impl.logging.LoggerFactory
import io.vertx.core.json.JsonObject

class EventLoopExample : AbstractVerticle() {

  val log = LoggerFactory.getLogger(EventLoopExample::class.simpleName)

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val v = Vertx.vertx()
      v.deployVerticle(EventLoopExample())

    }
  }

  @Throws(Exception::class)
  override fun start(startPromise: Promise<Void?>) {
    log.info("Start ${EventLoopExample::class.simpleName}")
    startPromise.complete()
//    Let See what happen when we block the thread -> it should show warning in log
//    NOTE: we should not block the thread
    Thread.sleep(5000)
  }
}
