package dev.dominiqn.objects.movie

import java.math.BigDecimal

class Money(private val amount: BigDecimal) {
    operator fun plus(other: Money): Money {
        return Money(this.amount + other.amount)
    }

    operator fun minus(other: Money): Money {
        return Money(this.amount - other.amount)
    }

    operator fun times(percent: Double): Money {
        return Money(this.amount * BigDecimal.valueOf(percent))
    }

    fun isLessThan(other: Money): Boolean {
        return this.amount < other.amount
    }

    fun isGreaterThanOrEqual(other: Money): Boolean {
        return this.amount >= other.amount
    }

    companion object {
        val ZERO = wons(0)

        fun wons(amount: Long): Money {
            return Money(BigDecimal.valueOf(amount))
        }

        fun wons(amount: Double): Money {
            return Money(BigDecimal.valueOf(amount))
        }
    }
}
