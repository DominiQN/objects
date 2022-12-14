package dev.dominiqn.objects.movie

class PercentDiscountPolicy(
    private val percent: Double,
    vararg conditions: DiscountCondition,
) : DiscountPolicy(*conditions) {
    override fun getDiscountAmount(screening: Screening): Money {
        return screening.movieFee * percent
    }
}
