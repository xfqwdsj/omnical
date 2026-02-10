package top.ltfan.omnical.icalendar.biweekly

import biweekly.property.Priority
import top.ltfan.omnical.icalendar.ICalendarPriority

/** Converts a [Priority] to an [ICalendarPriority]. */
@Suppress("NOTHING_TO_INLINE")
inline fun Priority.toOmnicalValue() = ICalendarPriority.fromValue(value.toUByte())

/** Converts an [ICalendarPriority] to a [Priority]. */
@Suppress("NOTHING_TO_INLINE")
inline fun ICalendarPriority.toBiweeklyValue() = Priority(value.toInt())
