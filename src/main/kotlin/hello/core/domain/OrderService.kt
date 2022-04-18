package hello.core.domain

import hello.core.Order.Order

interface OrderService {
    fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order
}