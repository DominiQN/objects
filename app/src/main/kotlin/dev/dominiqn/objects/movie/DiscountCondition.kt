package dev.dominiqn.objects.movie

fun interface DiscountCondition {
    fun isSatisfiedBy(screening: Screening): Boolean
}
