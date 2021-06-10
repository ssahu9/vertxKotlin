package com.spsah.self.vertxKotlin.verticles

import io.vertx.core.AbstractVerticle
import io.vertx.core.DeploymentOptions
import io.vertx.core.Promise
import io.vertx.core.Vertx
import io.vertx.core.json.JsonObject

class MainVerticle : AbstractVerticle() {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val v = Vertx.vertx()
      v.deployVerticle(MainVerticle())

    }
  }

  @Throws(Exception::class)
  override fun start(startPromise: Promise<Void?>) {
    println("Start ${MainVerticle::class.simpleName} ")
    vertx.deployVerticle(VerticleA()).onSuccess { r ->
      vertx.undeploy(r)
    }
//Scaling verticle B to 3 instance by using deployment options
    vertx.deployVerticle(VerticleB::class.java, DeploymentOptions().setInstances(3))

//    Using Config property
    vertx.deployVerticle(VerticleC::class.java,DeploymentOptions()
      .setInstances(2)
      .setConfig(JsonObject()
        .put("id",122)
        .put("name",VerticleC::class.simpleName)
    ))
    startPromise.complete()
  }
}
