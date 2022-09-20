package dev.dominiqn.objects.movie

import java.time.Duration

class Movie(
    private val title: String,
    private val runningTime: Duration,
    val fee: Money,
    private val discountPolicy: DiscountPolicy,
) {
    fun calculateMovieFee(screening: Screening): Money {
        return fee - discountPolicy.calculateDiscountAmount(screening)
    }
}
