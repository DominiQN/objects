package dev.dominiqn.objects.movie

interface DiscountCondition {
    fun isSatisfiedBy(screening: Screening): Boolean
}
