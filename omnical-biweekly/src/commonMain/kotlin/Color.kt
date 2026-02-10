package top.ltfan.omnical.icalendar.biweekly

import biweekly.property.Color
import top.ltfan.omnical.icalendar.ICalendarColor

/** Converts a [Color] to an [ICalendarColor]. */
@Suppress("NOTHING_TO_INLINE")
inline fun Color.toOmnicalValue() = ICalendarColor.fromValue(value.lowercase())

/** Converts an [ICalendarColor] to a [Color]. */
@Suppress("NOTHING_TO_INLINE")
inline fun ICalendarColor.toBiweeklyValue() = Color(value)
