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
        ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()))
    }
}
