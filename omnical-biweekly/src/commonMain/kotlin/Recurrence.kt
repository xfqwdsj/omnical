package top.ltfan.omnical.icalendar.biweekly

import biweekly.util.Recurrence
import kotlinx.datetime.DayOfWeek
import top.ltfan.omnical.icalendar.ICalendarRecurrenceRuleByDay
import top.ltfan.omnical.icalendar.ICalendarRecurrenceRuleFrequency
import kotlin.time.Instant

/**
 * Creates a [Recurrence.Builder] from an
 * [ICalendarRecurrenceRuleFrequency].
 */
@Suppress("NOTHING_TO_INLINE", "FunctionName")
inline fun RecurrenceBuilder(frequency: ICalendarRecurrenceRuleFrequency) =
    Recurrence.Builder(frequency.toBiweeklyValue())

/** Adds an UNTIL rule to the [Recurrence.Builder] with the given [Instant]. */
@Suppress("NOTHING_TO_INLINE")
inline fun Recurrence.Builder.until(instant: Instant?): Recurrence.Builder = until(instant?.let { ICalDate(it) })

/**
 * Adds a BYDAY rule to the [Recurrence.Builder] with the given [DayOfWeek]
 * and optional ordinal.
 */
@Suppress("NOTHING_TO_INLINE")
inline fun Recurrence.Builder.byDay(dayOfWeek: DayOfWeek, ordinal: Int? = null): Recurrence.Builder =
    byDay(ordinal, dayOfWeek.toBiweeklyValue())

/**
 * Adds a BYDAY rule to the [Recurrence.Builder] with the given
 * [ICalendarRecurrenceRuleByDay].
 */
@Suppress("NOTHING_TO_INLINE")
inline fun Recurrence.Builder.byDay(value: ICalendarRecurrenceRuleByDay): Recurrence.Builder =
    byDay(value.dayOfWeek, value.occurrence)

/**
 * Adds multiple BYDAY rules to the [Recurrence.Builder] with the given
 * [ICalendarRecurrenceRuleByDay] values.
 */
@Suppress("NOTHING_TO_INLINE")
inline fun Recurrence.Builder.byDay(values: Iterable<ICalendarRecurrenceRuleByDay>): Recurrence.Builder =
    values.fold(this) { builder, value -> builder.byDay(value) }

/**
 * Sets the week start day of the [Recurrence.Builder] to the given
 * [DayOfWeek].
 */
@Suppress("NOTHING_TO_INLINE")
inline fun Recurrence.Builder.weekStart(dayOfWeek: DayOfWeek?): Recurrence.Builder =
    workweekStarts(dayOfWeek?.toBiweeklyValue())
