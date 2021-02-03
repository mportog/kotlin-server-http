package models
import kotlinx.serialization.Serializable

val orderStorage = listOf(Order(
    "2021-02-02-01", listOf(
        OrderItem("Misto", 2, 5.50),
        OrderItem("Agua", 1, 1.50),
        OrderItem("Cerveja", 3, 2.30),
        OrderItem("Bolo", 1, 3.75)
    )),
    Order("2021-02-02-02", listOf(
        OrderItem("Cheeseburger", 1, 8.50),
        OrderItem("Agua", 2, 1.50),
        OrderItem("Coca-Cola", 2, 1.76),
        OrderItem("Sorvete", 1, 2.35)
    ))
)

@Serializable
data class Order(val number : String, val contents: List<OrderItem>)

@Serializable
data class OrderItem(val item:String, val amount: Int, val price : Double)

