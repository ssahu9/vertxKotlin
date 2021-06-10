package com.spsah.self.vertxKotlin.eventloop

import io.vertx.core.*
import io.vertx.core.impl.logging.Logger
import io.vertx.core.impl.logging.LoggerFactory
import io.vertx.core.json.JsonObject
import java.util.concurrent.TimeUnit

class EventLoopExample : AbstractVerticle() {

  val log = LoggerFactory.getLogger(EventLoopExample::class.simpleName)

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
//      Setting vertx option
//      1. To wait for half second before generating blocking warning
//      2. Check above in interval of 1 sec
//      3. we should not modify event pool size until for specific case
      val v = Vertx.vertx(
        VertxOptions()
          .setMaxEventLoopExecuteTime(500)
          .setMaxEventLoopExecuteTimeUnit(TimeUnit.MILLISECONDS)
          .setBlockedThreadCheckInterval(1)
          .setBlockedThreadCheckIntervalUnit(TimeUnit.SECONDS)
          .setEventLoopPoolSize(2)
      )
      v.deployVerticle(EventLoopExample::class.java,DeploymentOptions()
        .setInstances(4))

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
