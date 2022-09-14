package dev.dominiqn.objects.movie

interface DiscountPolicy {
    fun calculateDiscountAmount(screening: Screening): Money
}
