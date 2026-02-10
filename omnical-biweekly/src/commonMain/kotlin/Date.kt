package top.ltfan.omnical.icalendar.biweekly

import biweekly.util.ICalDate
import java.util.Date
import kotlin.time.Instant
import kotlin.time.toJavaInstant

/** Creates an [biweekly.util.ICalDate] from an [Instant]. */
@Suppress("NOTHING_TO_INLINE")
inline fun ICalDate(instant: Instant) = ICalDate(Date.from(instant.toJavaInstant()))
