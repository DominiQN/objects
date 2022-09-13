package dev.dominiqn.objects.ticketing

/**
 * 관람객
 */
class Audience(
    private val bag: Bag,
) {
    fun buy(ticket: Ticket): Long {
        bag.ticket = ticket
        if (bag.hasInvitation) {
            return 0L
        }
        bag.minusAmount(ticket.fee)
        return ticket.fee
    }
}
