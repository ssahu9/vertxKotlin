package com.spsah.self.vertxKotlin.verticles

import io.vertx.core.AbstractVerticle
import io.vertx.core.Promise
import io.vertx.core.Vertx

class VerticleC : AbstractVerticle() {


  @Throws(Exception::class)
  override fun start(startPromise: Promise<Void?>) {
    println("Start ${VerticleC::class.simpleName} ${config()} ")
    startPromise.complete()
  }
}
