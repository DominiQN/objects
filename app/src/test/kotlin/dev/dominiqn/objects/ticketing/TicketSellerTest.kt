package dev.dominiqn.objects.ticketing

import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

class TicketSellerTest : BehaviorSpec({
    given("sellTo") {
        val audience = mockk<Audience>()
        every { audience.buy(any()) } returns 10000L

        val ticketOffice = mockk<TicketOffice>(relaxed = true, relaxUnitFun = true)

        val ticketSeller = TicketSeller(ticketOffice)

        `when`("관람객에게 티켓을 팔면") {
            ticketSeller.sellTo(audience)

            then("관람객이 낸 돈을 매표소에 보관한다.") {
                verify(exactly = 1) { ticketOffice.plusAmount(10000L) }
            }
        }
    }
})
