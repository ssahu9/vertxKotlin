package com.spsah.self.vertxKotlin.verticles

import io.vertx.core.AbstractVerticle
import io.vertx.core.Promise
import io.vertx.core.Vertx

class VerticleB : AbstractVerticle() {


  @Throws(Exception::class)
  override fun start(startPromise: Promise<Void?>) {
    println("Start ${VerticleB::class.simpleName} ")
    startPromise.complete()
  }
}
