package dev.dominiqn.objects.ticketing

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.longs.shouldBeExactly
import java.time.LocalDateTime

class AudienceTest : BehaviorSpec({
    given("초대장이 있을 때") {
        val ticket = Ticket(fee = 10_000L)
        val invitation = Invitation(datetime = LocalDateTime.parse("2022-09-14T21:30:00"))
        val bag = Bag(amount = 0L, invitation = invitation)
        val audience = Audience(bag)

        `when`("티켓을 사면") {
            val amount = audience.buy(ticket)

            then("돈을 내지 않는다.") {
                amount shouldBeExactly 0L
            }
        }
    }

    given("초대장이 없을 때") {
        val ticket = Ticket(fee = 10_000L)
        val bag = Bag(amount = 0L)
        val audience = Audience(bag)

        `when`("티켓을 사면") {
            val amount = audience.buy(ticket)

            then("티켓 요금만큼 돈을 낸다.") {
                amount shouldBeExactly 10_000L
            }
        }
    }
})
