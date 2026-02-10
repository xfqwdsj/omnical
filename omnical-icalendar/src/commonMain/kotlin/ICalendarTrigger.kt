package top.ltfan.omnical.icalendar

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.Duration
import kotlin.time.Instant

/**
 * Represents the "TRIGGER" property of a VALARM component as defined in
 * [RFC 5545 Section 3.8.6.3](https://datatracker.ietf.org/doc/html/rfc5545#section-3.8.6.3).
 *
 * A trigger defines when an alarm fires. It can be defined either as a
 * relative offset (Duration) from the event's start or end, or as an
 * absolute point in time (Instant).
 */
@Serializable
sealed interface ICalendarTrigger {
    /**
     * A trigger that fires at a relative offset from the associated event or
     * to-do.
     *
     * @property offset The duration of the offset (e.g., negative duration for
     *   "before").
     * @property related Specifies whether the [offset] is relative to the
     *   start or end of the event.
     */
    @Serializable
    @SerialName("Relative")
    data class Relative(
        val offset: Duration,
        val related: Related = Start,
    ) : ICalendarTrigger {
        /** The reference point for a relative trigger offset. */
        @Serializable
        enum class Related {
            Start, End;
        }
    }

    /**
     * A trigger that fires at a specific, absolute date and time.
     *
     * @property time The exact [Instant] when the alarm should be triggered.
     */
    @Serializable
    @SerialName("Absolute")
    data class Absolute(val time: Instant) : ICalendarTrigger
}
