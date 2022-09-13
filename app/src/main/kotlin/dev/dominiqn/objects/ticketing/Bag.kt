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
    amount: Long,
    private val invitation: Invitation? = null,
) {
    var amount = amount
        private set

    /**
     * 초대장은 티켓으로 교환할 수 있다.
     */
    var ticket: Ticket? = null
        private set

    val hasTicket: Boolean
        get() = ticket != null

    private val hasInvitation: Boolean
        get() = invitation != null

    private fun minusAmount(amount: Long) {
        this.amount -= amount
    }

    fun plusAmount(amount: Long) {
        this.amount += amount
    }

    fun hold(ticket: Ticket): Long {
        this.ticket = ticket
        if (hasInvitation) {
            return 0L
        }
        minusAmount(ticket.fee)
        return ticket.fee
    }
}
