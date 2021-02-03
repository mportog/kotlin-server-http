package routes

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import models.orderStorage

    fun Route.listOrderRoute() {
        get("/order") {
            if (models.orderStorage.isNotEmpty()) {
                call.respond(orderStorage)
            }
        }
    }

    fun Route.getOrderRoute() {
        get("/order/{id}") {
            val id = call.parameters["id"] ?: return@get call.respondText(
                "Id mal-informado ou faltante",
                status = HttpStatusCode.BadRequest
            )
            val order = orderStorage.find { it.number == id } ?: return@get call.respondText(
                "Pedido não encontrado",
                status = HttpStatusCode.NotFound
            )
            call.respond(order)
        }

    }

    fun Route.totalOrderRoute(){
        get("/order/{id}/total"){
            val id = call.parameters["id"] ?: return@get call.respondText("Id mal-informado ou faltante",status = HttpStatusCode.BadRequest)
            val order = orderStorage.find { it.number == id } ?: return@get call.respondText("Pedido não encontrado", status = HttpStatusCode.NotFound)
            val total = order.contents.map { it.price*it.amount }.sum()
            call.respond(total)
        }
    }


fun Application.registerOrderRoutes() {
    routing {
        listOrderRoute()
        getOrderRoute()
        totalOrderRoute()
    }
}
