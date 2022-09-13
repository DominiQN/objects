package dev.dominiqn.objects.ticketing

/**
 * 매표소
 */
class TicketOffice(
    /**
     * 판매한 금액
     */
    private var amount: Long,
    tickets: List<Ticket>,
) {
    /**
     * 판매나 교환할 티켓 목록
     */
    private val tickets = tickets.toMutableList()

    fun getTicket(): Ticket {
        return tickets.removeFirst()
    }

    fun minusAmount(amount: Long) {
        this.amount -= amount
    }

    fun plusAmount(amount: Long) {
        this.amount += amount
    }
}
