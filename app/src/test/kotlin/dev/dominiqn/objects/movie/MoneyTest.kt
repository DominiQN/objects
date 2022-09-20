package dev.dominiqn.objects.movie

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*

internal class MoneyTest : BehaviorSpec({
    given("equals") {
        When("돈의 가격이 같으면") {
            val some = Money.wons(1000L)
            val other = Money.wons(1000L)

            then("동일하다.") {
                some shouldBe other
            }
        }
    }
})
