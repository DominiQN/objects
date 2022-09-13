package dev.dominiqn.objects.ticketing

import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.mockk
import io.mockk.verify

internal class TheaterTest : BehaviorSpec({
    given("enter") {
        val ticketSeller = mockk<TicketSeller>(relaxed = true)
        val audience = mockk<Audience>(relaxed = true)
        val theater = Theater(ticketSeller)

        `when`("관람객이 소극장에 입장하면") {
            theater.enter(audience)

            then("티켓 판매원은 관람객에게 티켓을 판다.") {
                verify(exactly = 1) { ticketSeller.sellTo(audience) }
            }
        }
    }
})
