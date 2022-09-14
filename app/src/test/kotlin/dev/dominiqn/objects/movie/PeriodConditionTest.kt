package dev.dominiqn.objects.movie

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.LocalTime

internal class PeriodConditionTest : BehaviorSpec({
    given("요일 불일치") {
        val screening = mockk<Screening>().apply {
            // 9월 13일은 화요일
            every { startTime } returns LocalDateTime.parse("2022-09-13T22:00:00")
        }

        val condition = PeriodCondition(
            dayOfWeek = DayOfWeek.WEDNESDAY,
            startTime = LocalTime.parse("21:30"),
            endTime = LocalTime.parse("22:30"),
        )
        `when`("상영 요일이 다르면") {
            val isSatisfiedByCondition = condition.isSatisfiedBy(screening)

            then("할인 불가능하다.") {
                isSatisfiedByCondition shouldBe false
            }
        }
    }

    given("상영 시작시간이 기간 밖") {
        val condition = PeriodCondition(
            dayOfWeek = DayOfWeek.WEDNESDAY,
            startTime = LocalTime.parse("21:30"),
            endTime = LocalTime.parse("22:30"),
        )

        val screeningBeforeCondition = mockk<Screening>().apply {
            every { startTime } returns LocalDateTime.parse("2022-09-14T12:00:00")
        }
        `when`("상영 시작시간이 기간보다 이전이면") {
            val isSatisfiedByCondition = condition.isSatisfiedBy(screeningBeforeCondition)

            then("할인 불가능하다.") {
                isSatisfiedByCondition shouldBe false
            }
        }

        val screeningAfterCondition = mockk<Screening>().apply {
            every { startTime } returns LocalDateTime.parse("2022-09-14T23:30:00")
        }
        `when`("상영 시작시간이 기간보다 이후라면") {
            val isSatisfiedByCondition = condition.isSatisfiedBy(screeningAfterCondition)

            then("할인 불가능하다.") {
                isSatisfiedByCondition shouldBe false
            }
        }
    }

    given("isSatisfiedBy") {
        val screening = mockk<Screening>().apply {
            every { startTime } returns LocalDateTime.parse("2022-09-14T22:00:00")
        }

        val condition = PeriodCondition(
            dayOfWeek = DayOfWeek.WEDNESDAY,
            startTime = LocalTime.parse("21:30"),
            endTime = LocalTime.parse("22:30"),
        )
        `when`("상영 시작시간이 기간 내에 있지 않다면") {
            val isSatisfiedByCondition = condition.isSatisfiedBy(screening)

            then("할인 가능하다.") {
                isSatisfiedByCondition shouldBe true
            }
        }
    }
})
