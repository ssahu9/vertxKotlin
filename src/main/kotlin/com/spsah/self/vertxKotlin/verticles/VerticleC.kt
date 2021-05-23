package com.spsah.self.vertxKotlin.verticles

import io.vertx.core.AbstractVerticle
import io.vertx.core.Promise
import io.vertx.core.impl.logging.Logger
import io.vertx.core.impl.logging.LoggerFactory


class VerticleC : AbstractVerticle() {

  var log: Logger = LoggerFactory.getLogger(VerticleC::class.simpleName)


  @Throws(Exception::class)
  override fun start(startPromise: Promise<Void?>) {
    log.info("logger")
    println("Start ${VerticleC::class.simpleName} ${config()} ")
    startPromise.complete()
  }
}
