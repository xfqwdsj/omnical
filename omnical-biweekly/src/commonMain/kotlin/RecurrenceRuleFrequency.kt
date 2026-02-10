package top.ltfan.omnical.icalendar.biweekly

import biweekly.util.Frequency
import top.ltfan.omnical.icalendar.ICalendarRecurrenceRuleFrequency

/** Converts a [Frequency] to an [ICalendarRecurrenceRuleFrequency]. */
@Suppress("NOTHING_TO_INLINE")
inline fun Frequency.toOmnicalValue(): ICalendarRecurrenceRuleFrequency = when (this) {
    SECONDLY -> Secondly
    MINUTELY -> Minutely
    HOURLY -> Hourly
    DAILY -> Daily
    WEEKLY -> Weekly
    MONTHLY -> Monthly
    YEARLY -> Yearly
}

/** Converts an [ICalendarRecurrenceRuleFrequency] to a [Frequency]. */
@Suppress("NOTHING_TO_INLINE")
inline fun ICalendarRecurrenceRuleFrequency.toBiweeklyValue(): Frequency = when (this) {
    Secondly -> SECONDLY
    Minutely -> MINUTELY
    Hourly -> HOURLY
    Daily -> DAILY
    Weekly -> WEEKLY
    Monthly -> MONTHLY
    Yearly -> YEARLY
}
