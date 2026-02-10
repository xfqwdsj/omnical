package top.ltfan.omnical.icalendar

import kotlinx.serialization.Serializable

/** Defines the base recurring interval for an [ICalendarRecurrenceRule]. */
@Serializable
enum class ICalendarRecurrenceRuleFrequency {
    Secondly,
    Minutely,
    Hourly,
    Daily,
    Weekly,
    Monthly,
    Yearly;
}
