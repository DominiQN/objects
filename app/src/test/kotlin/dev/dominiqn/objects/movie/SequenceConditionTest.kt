package dev.dominiqn.objects.movie

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

internal class SequenceConditionTest : BehaviorSpec({
    given("isSatisfiedBy") {
        val sequence = 2
        val screening = mockk<Screening>()
        every { screening.isSequence(2) } returns true

        val condition = SequenceCondition(2)

        `when`("조건 내 순번이 상영 순번과 일치할 경우") {
            val isSatisfiedByCondition = condition.isSatisfiedBy(screening)

            then("할인 가능하다.") {
                isSatisfiedByCondition shouldBe true
            }
        }
    }

    given("isUnsatisfiedBy") {
        val sequence = 2
        val screening = mockk<Screening>()
        every { screening.isSequence(2) } returns false

        val condition = SequenceCondition(2)

        `when`("조건 내 순번이 상영 순번과 일치할 경우") {
            val isSatisfiedByCondition = condition.isSatisfiedBy(screening)

            then("할인 가능하다.") {
                isSatisfiedByCondition shouldBe false
            }
        }
    }
})
