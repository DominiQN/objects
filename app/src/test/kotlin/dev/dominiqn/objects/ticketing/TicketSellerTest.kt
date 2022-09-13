package dev.dominiqn.objects.ticketing

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.spyk
import io.mockk.verify
import java.time.LocalDateTime

class TicketSellerTest : BehaviorSpec({
    given("초대장을 가진 관람객에게") {
        val ticketPrice = 5000L
        val ticketOffice = TicketOffice(amount = 0L, tickets = listOf(Ticket(ticketPrice)))
        val ticketSeller = TicketSeller(ticketOffice)

        val bag = Bag(amount = 0L, invitation = Invitation(LocalDateTime.parse("2022-09-08T21:30:00")))
            .let(::spyk)
        val audience = Audience(bag)

        `when`("티켓을 팔면") {
            ticketSeller.sellTo(audience)

            then("관람객은 돈을 내지 않고 티켓을 가진다.") {
                verify(exactly = 0) { bag.minusAmount(ticketPrice) }
                audience.bag.hasTicket shouldBe true
            }
        }
    }

    given("초대장을 가지지 않은 관람객에게") {
        val ticketPrice = 5000L
        val ticketOffice = TicketOffice(amount = 0L, tickets = listOf(Ticket(ticketPrice)))
        val ticketSeller = TicketSeller(ticketOffice)

        val bag = Bag(amount = 0L)
            .let(::spyk)
        val audience = Audience(bag)

        `when`("티켓을 팔면") {
            ticketSeller.sellTo(audience)

            then("관람객은 돈을 내고 티켓을 가진다.") {
                verify(exactly = 1) { bag.minusAmount(ticketPrice) }
                audience.bag.hasTicket shouldBe true
            }
        }
    }
})
