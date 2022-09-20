package dev.dominiqn.objects.movie

import java.time.LocalDateTime

class Screening(
    private val movie: Movie,
    private val sequence: Int,
    private val whenScreened: LocalDateTime,
) {
    val startTime: LocalDateTime
        get() = whenScreened

    val movieFee: Money
        get() = movie.fee

    fun isSequence(sequence: Int): Boolean {
        return this.sequence == sequence
    }

    fun reserve(customer: Customer, audienceCount: Int): Reservation {
        return Reservation(
            customer = customer,
            screening = this,
            fee = calculateFee(audienceCount),
            audienceCount = audienceCount,
        )
    }

    private fun calculateFee(audienceCount: Int): Money {
        return movie.calculateMovieFee(this) * audienceCount.toDouble()
    }
}
