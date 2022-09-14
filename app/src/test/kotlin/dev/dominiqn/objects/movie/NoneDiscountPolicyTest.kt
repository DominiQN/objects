package dev.dominiqn.objects.movie

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

internal class NoneDiscountPolicyTest : BehaviorSpec({
    given("discountAmount") {
        val policy = NoneDiscountPolicy()

        val screening = mockk<Screening>()
        listOf(
            Money.wons(1000),
            Money.wons(3000),
        ).forAll { screeningFee ->
            every { screening.movieFee } returns screeningFee

            `when`("상영 가격과 상관없이") {
                val discountAmount = policy.calculateDiscountAmount(screening)

                then("할인하지 않는다.") {
                    discountAmount shouldBe Money.ZERO
                }
            }
        }
    }
})
