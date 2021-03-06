package com.jetbrains.handson.httpapi

import com.jetbrains.handson.routes.registerCustomerRoutes
import com.jetbrains.handson.routes.registerOrderRoutes
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.HttpHeaders
import io.ktor.serialization.*


fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module(testing: Boolean = false) {
    install(CORS) {
        host("*")
        header(HttpHeaders.ContentType)
    }

    install(ContentNegotiation) {
        json()
    }
    registerCustomerRoutes()
    registerOrderRoutes()
}
