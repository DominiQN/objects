package dev.dominiqn.objects.ticketing

/**
 * 티켓 판매원
 */
class TicketSeller(
    /**
     * 자신이 일하는 매표소
     */
    private val ticketOffice: TicketOffice,
) {
    fun sellTo(audience: Audience) {
        if (audience.bag.hasInvitation) {
            val ticket = ticketOffice.getTicket()
            audience.bag.ticket = ticket
        } else {
            val ticket = ticketOffice.getTicket()
            audience.bag.minusAmount(ticket.fee)
            ticketOffice.plusAmount(ticket.fee)
            audience.bag.ticket = ticket
        }
    }
}
