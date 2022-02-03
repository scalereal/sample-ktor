package com.example.plugins

import com.example.models.Employee
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.plugins.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import io.ktor.server.routing.*

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json()
    }
    val employees = mutableListOf<Employee>()
    routing {
        get("/employee") {
            call.respond(employees)
        }

        post("/employee") {
            val requestBody = call.receive<Employee>()
            employees.add(requestBody)
            call.respond(requestBody)
        }
    }
}
