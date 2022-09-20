package dev.dominiqn.objects.movie

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*

internal class AmountDiscountPolicyTest : BehaviorSpec({
    given("discountAmount") {
        val policy = AmountDiscountPolicy(
            discountAmount = Money.wons(2000),
            { true },
        )

        val screening = mockk<Screening>()
        listOf(
            Money.wons(1000),
            Money.wons(3000),
        ).forAll { screeningFee ->
            every { screening.movieFee } returns screeningFee

            `when`("상영 가격과 상관없이") {
                val discountAmount = policy.calculateDiscountAmount(screening)

                then("할인 정책에 정해진 액수만큼 할인한다.") {
                    discountAmount shouldBe Money.wons(2000)
                }
            }
        }
    }
})
