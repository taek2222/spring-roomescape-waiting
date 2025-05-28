package roomescape.reservation.domain;

import java.time.LocalDate;

public class ReservationCreate {

    private final Long memberId;
    private final Long themeId;
    private final LocalDate date;
    private final Long reservationTimeId;
    private final boolean isWaiting;

    private ReservationCreate(Long memberId, Long themeId, LocalDate date, Long reservationTimeId,
                              boolean isWaiting) {
        this.memberId = memberId;
        this.themeId = themeId;
        this.date = date;
        this.reservationTimeId = reservationTimeId;
        this.isWaiting = isWaiting;
    }

    public static ReservationCreate forNormalReservation(
            Long memberId,
            Long themeId,
            LocalDate date,
            Long timeId
    ) {
        return new ReservationCreate(memberId, themeId, date, timeId, false);
    }

    public static ReservationCreate forWaitingReservation(
            Long memberId,
            Long themeId,
            LocalDate date,
            Long timeId
    ) {
        return new ReservationCreate(memberId, themeId, date, timeId, true);
    }

    public Long getMemberId() {
        return memberId;
    }

    public Long getThemeId() {
        return themeId;
    }

    public LocalDate getDate() {
        return date;
    }

    public Long getReservationTimeId() {
        return reservationTimeId;
    }

    public boolean isWaiting() {
        return isWaiting;
    }
}
