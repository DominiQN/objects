package dev.dominiqn.objects.ticketing

/**
 * 소극장
 */
class Theater(
    private val ticketSeller: TicketSeller,
) {
    /**
     * 관람객 입장
     */
    fun enter(audience: Audience) {
        if (audience.bag.hasInvitation) {
            val ticket = ticketSeller.ticketOffice.getTicket()
            audience.bag.ticket = ticket
        } else {
            val ticket = ticketSeller.ticketOffice.getTicket()
            audience.bag.minusAmount(ticket.fee)
            ticketSeller.ticketOffice.plusAmount(ticket.fee)
            audience.bag.ticket = ticket
        }
    }
}
