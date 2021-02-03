package routes

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import models.Customer
import models.customerStorage

fun Route.customerRouting(){
    route("/customer"){
        get{
            if(customerStorage.isNotEmpty()){
                call.respond(customerStorage)
            }else{
                call.respondText("Não há clientes cadastrados", status = HttpStatusCode.NotFound)
            }
        }
        get("{id}"){
            val id = call.parameters["id"] ?: return@get call.respondText(
                "Id mal-informado ou faltante",
                status = HttpStatusCode.BadRequest
            )
            val customer = customerStorage.find { it.id == id } ?: return@get call.respondText(
                "Cliente com id: $id não encontrado",
                status = HttpStatusCode.NotFound
            )
            call.respond(customer)
        }
        post {
            val customer = call.receive<Customer>()
            customerStorage.add(customer)
            call.respondText (
                "Cliente criado com sucesso", status = HttpStatusCode.Created
            )
        }
        delete ("{id}"){
            val id = call.parameters["id"] ?: return@delete call.respond(HttpStatusCode.BadRequest)
            if(customerStorage.removeIf{it.id == id}){
                call.respondText("Cliente removido com sucesso", status = HttpStatusCode.OK)
            }else{
                call.respondText("Cliente não encontrado", status = HttpStatusCode.NotFound)
            }
        }
    }
}
fun Application.registerCustomerRoutes() {
    routing {
        customerRouting()
    }
}