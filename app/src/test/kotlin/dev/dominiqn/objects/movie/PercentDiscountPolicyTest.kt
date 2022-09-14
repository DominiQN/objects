package dev.dominiqn.objects.movie

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

internal class PercentDiscountPolicyTest : BehaviorSpec({
    given("discountAmount") {
        val policy = PercentDiscountPolicy(
            percent = 0.1,
            { true },
        )

        val screening = mockk<Screening>()
        listOf(
            Money.wons(1_000) to Money.wons(100.0),
            Money.wons(3_000) to Money.wons(300.0),
        ).forAll { (screeningFee, expectedDiscountAmount) ->
            every { screening.movieFee } returns screeningFee

            When("할인 정책이 비율할인이라면") {
                val actualDiscountAmount = policy.calculateDiscountAmount(screening)

                then("정책 비율만큼 할인한다.") {
                    actualDiscountAmount shouldBe expectedDiscountAmount
                }
            }
        }
    }
})
