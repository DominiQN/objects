package dev.dominiqn.objects.ticketing

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.longs.shouldBeExactly
import io.mockk.every
import io.mockk.mockk

class AudienceTest : BehaviorSpec({
    given("buy") {
        val ticket = mockk<Ticket>()

        val bag = mockk<Bag>()
        every { bag.hold(any()) } returns 3_000L

        val audience = Audience(bag)

        `when`("티켓을 구매하면") {
            val amount = audience.buy(ticket)

            then("가방에서 꺼낸 금액을 지불한다.") {
                amount shouldBeExactly 3_000L
            }
        }
    }
})
