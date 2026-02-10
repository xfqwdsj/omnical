package top.ltfan.omnical.icalendar.biweekly

import biweekly.parameter.Related
import top.ltfan.omnical.icalendar.ICalendarTrigger

/** Converts a [Related] to an [ICalendarTrigger.Relative.Related]. */
@Suppress("NOTHING_TO_INLINE")
inline fun Related.toOmnicalValue(): ICalendarTrigger.Relative.Related = when (this) {
    START -> Start
    END -> End
    else -> error("Unexpected Related value: $this")
}

/** Converts an [ICalendarTrigger.Relative.Related] to a [Related]. */
@Suppress("NOTHING_TO_INLINE")
inline fun ICalendarTrigger.Relative.Related.toBiweeklyValue(): Related = when (this) {
    Start -> START
    End -> END
}
