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
        ticketSeller.sellTo(audience)
    }
}
