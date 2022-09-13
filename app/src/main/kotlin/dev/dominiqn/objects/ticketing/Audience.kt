package dev.dominiqn.objects.ticketing

/**
 * 관람객
 */
class Audience(
    private val bag: Bag,
) {
    fun buy(ticket: Ticket): Long {
        return bag.hold(ticket)
    }
}
