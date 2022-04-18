package hello.core.Order

data class Order(
    val memberId: Long,
    val itemName: String,
    val itemPrice: Int,
    val discountPrice: Int
)

fun Order.calculatePrice(): Int {
    return itemPrice - discountPrice
}
