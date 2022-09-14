package dev.dominiqn.objects.movie

abstract class DiscountPolicy(private val conditions: List<DiscountCondition>) {
    constructor(vararg conditions: DiscountCondition) : this(conditions.toList())

    fun calculateDiscountAmount(screening: Screening): Money {
        if (conditions.any { condition -> condition.isSatisfiedBy(screening) }) {
            return getDiscountAmount(screening)
        }

        return Money.ZERO
    }

    protected abstract fun getDiscountAmount(screening: Screening): Money
}
