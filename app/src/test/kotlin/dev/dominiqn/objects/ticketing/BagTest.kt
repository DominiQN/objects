package dev.dominiqn.objects.ticketing

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.longs.shouldBeExactly
import io.kotest.matchers.shouldBe
import java.time.LocalDateTime

class BagTest : BehaviorSpec({
    given("constructor") {
        `when`("생성되면") {
            val bag = Bag(amount = 0L)
            then("티켓이 없다.") {
                bag.hasTicket shouldBe false
            }
        }
    }

    given("가방에 초대장이 있을 때") {
        val ticket = Ticket(fee = 8_000L)
        val invitation = Invitation(LocalDateTime.parse("2022-09-15T21:30:00"))
        val bag = Bag(amount = 10_000L, invitation = invitation)
        `when`("가방에 티켓을 넣으면") {
            val amount = bag.hold(ticket)
            then("티켓을 가지고 있지만, 돈을 꺼내지 않는다.") {
                bag.hasTicket shouldBe true
                bag.amount shouldBeExactly 10_000L
                amount shouldBeExactly 0L
            }
        }
    }

    given("가방에 초대장이 없을 때") {
        val ticket = Ticket(fee = 8_000L)
        val bag = Bag(amount = 10_000L)
        `when`("가방에 티켓을 넣으면") {
            val amount = bag.hold(ticket)
            then("티켓을 가지고 있지만, 돈을 꺼내지 않는다.") {
                bag.hasTicket shouldBe true
                bag.amount shouldBeExactly 2_000L
                amount shouldBeExactly 8_000L
            }
        }
    }
})
