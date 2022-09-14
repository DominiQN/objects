package dev.dominiqn.objects.movie

import java.time.DayOfWeek
import java.time.LocalTime

class PeriodCondition(
    private val dayOfWeek: DayOfWeek,
    private val startTime: LocalTime,
    private val endTime: LocalTime,
) : DiscountCondition {
    override fun isSatisfiedBy(screening: Screening): Boolean {
        return (screening.startTime.dayOfWeek == this.dayOfWeek) &&
            (this.startTime <= screening.startTime.toLocalTime()) &&
            (this.endTime >= screening.startTime.toLocalTime())
    }
}
