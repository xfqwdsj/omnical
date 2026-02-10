package top.ltfan.omnical.icalendar

import kotlinx.datetime.DayOfWeek
import kotlinx.serialization.Serializable
import kotlin.time.Instant

/**
 * Represents the "RRULE" (Recurrence Rule) property as defined in
 * [RFC 5545 Section 3.8.5.3](https://datatracker.ietf.org/doc/html/rfc5545#section-3.8.5.3).
 *
 * This class encapsulates the logic for repeating events, defining how
 * often and for how long a recurrence should occur.
 *
 * @property frequency The type of recurrence unit (e.g., Daily, Weekly).
 *   Required.
 * @property interval A positive integer representing how often the
 *   frequency repeats.
 * @property count The total number of occurrences. Cannot be used with
 *   [until].
 * @property until The date-time that bounds the recurrence. Cannot be used
 *   with [count].
 * @property bySecond List of seconds (0-60) within a minute.
 * @property byMinute List of minutes (0-59) within an hour.
 * @property byHour List of hours (0-23) within a day.
 * @property byDay List of specific days of the week with optional ordinals
 *   (e.g., "Every Monday", "First Sunday").
 * @property byMonthDay List of days within a month (1-31 or -31 to -1).
 * @property byYearDay List of days within a year (1-366 or -366 to -1).
 * @property byWeekNo List of ordinals specifying weeks of the year (1-53
 *   or -53 to -1).
 * @property byMonth List of months of the year (1-12).
 * @property bySetPos List of values which filters the generated recurrence
 *   set (e.g., [1] limits to the first occurrence).
 * @property weekStart Specifies the day on which the workweek starts.
 */
@Serializable
data class ICalendarRecurrenceRule(
    val frequency: ICalendarRecurrenceRuleFrequency,
    val interval: Int? = null,
    val count: Int? = null,
    val until: Instant? = null,
    val bySecond: List<Int> = emptyList(),
    val byMinute: List<Int> = emptyList(),
    val byHour: List<Int> = emptyList(),
    val byDay: List<ICalendarRecurrenceRuleByDay> = emptyList(),
    val byMonthDay: List<Int> = emptyList(),
    val byYearDay: List<Int> = emptyList(),
    val byWeekNo: List<Int> = emptyList(),
    val byMonth: List<Int> = emptyList(),
    val bySetPos: List<Int> = emptyList(),
    val weekStart: DayOfWeek? = null,
)
