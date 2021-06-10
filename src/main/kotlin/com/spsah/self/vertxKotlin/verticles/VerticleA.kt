package com.spsah.self.vertxKotlin.verticles

import io.vertx.core.AbstractVerticle
import io.vertx.core.Promise
import io.vertx.core.Vertx

class VerticleA : AbstractVerticle() {


  @Throws(Exception::class)
  override fun start(startPromise: Promise<Void?>) {
    print("Start ${VerticleA::class.simpleName} ")
    startPromise.complete()
  }
}
