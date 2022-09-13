package dev.dominiqn.objects.ticketing

import java.time.LocalDateTime

/**
 * 이벤트 당첨자에게 발송되는 초대장
 *
 * 티켓으로 교환할 수 있다.
 */
class Invitation(
    /**
     * 관람일자
     */
    val datetime: LocalDateTime,
)
