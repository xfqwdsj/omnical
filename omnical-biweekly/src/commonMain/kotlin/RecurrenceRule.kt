package top.ltfan.omnical.icalendar.biweekly

import biweekly.ICalVersion
import biweekly.io.ParseContext
import biweekly.io.TimezoneAssignment
import biweekly.io.TimezoneInfo
import biweekly.io.WriteContext
import biweekly.io.scribe.property.RecurrenceRuleScribe
import biweekly.property.RecurrenceRule
import biweekly.util.Recurrence
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toJavaZoneId
import top.ltfan.omnical.icalendar.ICalendarRecurrenceRule
import kotlin.time.toKotlinInstant

/**
 * Converts a [Recurrence] to an [ICalendarRecurrenceRule].
 *
 * @param errors An optional list to which error messages will be added if
 *   the conversion fails.
 * @return The converted [ICalendarRecurrenceRule], or null if the
 *   conversion fails.
 */
@Suppress("NOTHING_TO_INLINE")
inline fun Recurrence.toOmnicalValue(errors: MutableList<String>? = null): ICalendarRecurrenceRule? {
    return ICalendarRecurrenceRule(
        frequency = frequency?.toOmnicalValue() ?: run {
            errors?.add("Frequency is null")
            return null
        },
        interval = interval,
        count = count,
        until = until?.toInstant()?.toKotlinInstant(),
        bySecond = bySecond,
        byMinute = byMinute,
        byHour = byHour,
        byDay = byDay.map { it.toOmnicalValue() },
        byMonthDay = byMonthDay,
        byYearDay = byYearDay,
        byWeekNo = byWeekNo,
        byMonth = byMonth,
        bySetPos = bySetPos,
        weekStart = workweekStarts?.toKotlinDayOfWeek(),
    )
}

/** Converts an [ICalendarRecurrenceRule] to a [Recurrence]. */
@Suppress("NOTHING_TO_INLINE")
inline fun ICalendarRecurrenceRule.toBiweeklyValue(): Recurrence = RecurrenceBuilder(frequency)
    .apply {
        interval(interval)
        count(count)
        until(until)
        bySecond(bySecond)
        byMinute(byMinute)
        byHour(byHour)
        byDay(byDay)
        byMonthDay(byMonthDay)
        byYearDay(byYearDay)
        byWeekNo(byWeekNo)
        byMonth(byMonth)
        bySetPos(bySetPos)
        weekStart(weekStart)
    }.build()

/**
 * Parses a string into an [ICalendarRecurrenceRule] using the biweekly
 * library.
 *
 * @param value The string to parse, typically in the format of an RRULE
 *   property value.
 * @param version The iCalendar version to use for parsing. Defaults to
 *   [DefaultICalVersion].
 * @param errors An optional mutable list to which error messages will be
 *   added if parsing fails.
 * @return The parsed [ICalendarRecurrenceRule], or null if parsing fails.
 */
fun ICalendarRecurrenceRule.Companion.parse(
    value: String,
    version: ICalVersion = DefaultICalVersion,
    errors: MutableList<String>? = null,
): ICalendarRecurrenceRule? {
    val parseContext = ParseContext().apply {
        this.version = version
    }
    return runCatching {
        RecurrenceRuleScribe()
            .parseText(value, null, null, parseContext)
            ?.value
            ?.toOmnicalValue(errors) ?: return null
    }.getOrNull()
}

/**
 * Serializes an [ICalendarRecurrenceRule] into a string using the biweekly
 * library.
 *
 * @param version The iCalendar version to use for serialization. Defaults
 *   to [DefaultICalVersion].
 * @param defaultTimeZone The default time zone to use for serialization.
 *   Defaults to the system's current default time zone.
 * @return The serialized string representation of the recurrence rule,
 *   suitable for use as an RRULE property value.
 */
fun ICalendarRecurrenceRule.format(
    version: ICalVersion = DefaultICalVersion,
    defaultTimeZone: TimeZone = TimeZone.currentSystemDefault(),
): String {
    val javaTimeZone = java.util.TimeZone.getTimeZone(defaultTimeZone.toJavaZoneId())
    val timezoneInfo = TimezoneInfo().apply {
        defaultTimezone = TimezoneAssignment(
            javaTimeZone, javaTimeZone.id,
        )
    }
    val writeContext = WriteContext(version, timezoneInfo, null)
    return RecurrenceRuleScribe().writeText(RecurrenceRule(toBiweeklyValue()), writeContext)
}
