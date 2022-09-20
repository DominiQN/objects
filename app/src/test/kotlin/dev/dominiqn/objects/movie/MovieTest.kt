package dev.dominiqn.objects.movie

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.time.DayOfWeek
import java.time.DayOfWeek.THURSDAY
import java.time.DayOfWeek.TUESDAY
import java.time.Duration
import java.time.LocalDateTime
import java.time.LocalTime

internal class MovieTest : BehaviorSpec({
    given("요금 계산") {
        val movie = Movie(
            title = "타이타닉",
            runningTime = Duration.ofMinutes(180),
            fee = Money.wons(11_000),
            discountPolicy = PercentDiscountPolicy(
                percent = 0.1,
                PeriodCondition(TUESDAY, start = "14:00", end = "16:59"),
                SequenceCondition(2),
                PeriodCondition(THURSDAY, start = "10:00", end = "13:59"),
            )
        )

        val `월요일 8시 1번` = Screening(
            movie = movie,
            sequence = 1,
            whenScreened = LocalDateTime.parse("2022-09-12T20:00")
        )
        When("월요일 8시에 1번으로 상영하면") {
            val actualMovieFee = movie.calculateMovieFee(`월요일 8시 1번`)

            then("아무 조건에도 걸리지 않아 할인이 없다.") {
                actualMovieFee shouldBe Money.wons(11_000)
            }
        }

        val `화요일 15시 1번째` = Screening(
            movie = movie,
            sequence = 1,
            whenScreened = LocalDateTime.parse("2022-09-13T15:00")
        )
        When("화요일 15시에 1번으로 상영하면") {
            val actualMovieFee = movie.calculateMovieFee(`화요일 15시 1번째`)

            then("첫 번째 조건 (화요일 14:00 ~ 16:59)에 걸려 10% 할인된다.") {
                actualMovieFee shouldBe Money.wons(9_900.0)
            }
        }

        val `수요일 10시 2번째` = Screening(
            movie = movie,
            sequence = 2,
            whenScreened = LocalDateTime.parse("2022-09-14T10:00")
        )
        When("월요일 10시에 2번으로 상영하면") {
            val actualMovieFee = movie.calculateMovieFee(`수요일 10시 2번째`)

            then("두 번째 조건 (당일 2번째)에 걸려 10% 할인된다.") {
                actualMovieFee shouldBe Money.wons(9_900.0)
            }
        }

        val `목요일 11시 3번째` = Screening(
            movie = movie,
            sequence = 3,
            whenScreened = LocalDateTime.parse("2022-09-15T11:00")
        )
        When("목요일 11시에 3번으로 상영하면") {
            val actualMovieFee = movie.calculateMovieFee(`목요일 11시 3번째`)

            then("세 번째 조건 (목요일 10:00 ~ 13:59)에 걸려 10% 할인된다.") {
                actualMovieFee shouldBe Money.wons(9_900.0)
            }
        }
    }
}) {
    companion object {
        private fun PeriodCondition(dayOfWeek: DayOfWeek, start: String, end: String): PeriodCondition {
            return PeriodCondition(
                dayOfWeek = dayOfWeek,
                startTime = LocalTime.parse(start),
                endTime = LocalTime.parse(end),
            )
        }
    }
}
