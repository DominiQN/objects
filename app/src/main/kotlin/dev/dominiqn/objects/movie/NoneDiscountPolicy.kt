package dev.dominiqn.objects.movie

class NoneDiscountPolicy : DiscountPolicy() {
    override fun getDiscountAmount(screening: Screening): Money {
        return Money.ZERO
    }
}
