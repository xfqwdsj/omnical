package top.ltfan.omnical.icalendar

import kotlinx.datetime.DayOfWeek
import kotlinx.serialization.Serializable

/**
 * Represents a specific day of the week within a recurrence rule,
 * optionally scoped by an ordinal offset.
 *
 * @property dayOfWeek The specific day (Monday-Sunday).
 * @property occurrence An optional integer indicating the specific occurrence
 *   within the period (e.g., `1` for the first occurrence, `-1` for the
 *   last). Commonly used in [ICalendarRecurrenceRuleFrequency.Monthly] or
 *   [ICalendarRecurrenceRuleFrequency.Yearly].
 */
@Serializable
data class ICalendarRecurrenceRuleByDay(
    val dayOfWeek: DayOfWeek,
    val occurrence: Int? = null,
)
