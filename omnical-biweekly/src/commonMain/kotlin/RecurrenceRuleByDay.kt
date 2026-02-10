package top.ltfan.omnical.icalendar.biweekly

import biweekly.util.ByDay
import top.ltfan.omnical.icalendar.ICalendarRecurrenceRuleByDay

/** Converts a [ByDay] to an [ICalendarRecurrenceRuleByDay]. */
@Suppress("NOTHING_TO_INLINE")
inline fun ByDay.toOmnicalValue() = ICalendarRecurrenceRuleByDay(
    dayOfWeek = day.toKotlinDayOfWeek(),
    occurrence = num,
)

/** Converts an [ICalendarRecurrenceRuleByDay] to a [ByDay]. */
@Suppress("NOTHING_TO_INLINE")
inline fun ICalendarRecurrenceRuleByDay.toBiweeklyValue() = ByDay(
    occurrence,
    dayOfWeek.toBiweeklyValue(),
)
