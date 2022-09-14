package dev.dominiqn.objects.movie

interface Movie {
    val fee: Money

    fun calculateMovieFee(screening: Screening): Money
}
