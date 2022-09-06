package dev.dominiqn.objects.ticketing

/**
 * 관람객의 소지품을 보관하는 가방
 *
 * - 경우
 *    - 현금과 초대장이 함께 있는 경우
 *    - 현금만 있는 경우
 *
 */
class Bag(
    /**
     * 현금
     */
    private var amount: Long,
    private val invitation: Invitation? = null,
) {
    /**
     * 초대장은 티켓으로 교환할 수 있다.
     */
    var ticket: Ticket? = null

    val hasTicket: Boolean
        get() = ticket != null

    val hasInvitation: Boolean
        get() = invitation != null

    fun minusAmount(amount: Long) {
        this.amount -= amount
    }

    fun plusAmount(amount: Long) {
        this.amount += amount
    }
}
