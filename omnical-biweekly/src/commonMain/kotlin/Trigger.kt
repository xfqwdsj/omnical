package top.ltfan.omnical.icalendar.biweekly

import biweekly.property.Trigger
import top.ltfan.omnical.icalendar.ICalendarTrigger
import kotlin.time.toKotlinInstant

/**
 * Converts a [Trigger] to an [ICalendarTrigger]. Returns null if the
 * trigger is invalid, and adds an error message to the provided list if
 * so.
 *
 * @param errors An optional mutable list to which error messages will be
 *   added if the trigger is invalid.
 * @return The converted [ICalendarTrigger], or null if the trigger is
 *   invalid.
 */
@Suppress("NOTHING_TO_INLINE")
inline fun Trigger.toOmnicalValue(errors: MutableList<String>? = null): ICalendarTrigger? {
    duration?.let { duration ->
        return ICalendarTrigger.Relative(
            offset = duration.toKotlinDuration(),
            related = when (related) {
                END -> End
                else -> Start
            },
        )
    }
    date?.let { date ->
        return ICalendarTrigger.Absolute(
            time = date.toInstant().toKotlinInstant(),
        )
    }
    errors?.add("Trigger property is neither duration-based nor date-based.")
    return null
}

/** Converts an [ICalendarTrigger] to a [Trigger]. */
@Suppress("NOTHING_TO_INLINE")
inline fun ICalendarTrigger.toBiweeklyValue(): Trigger = when (this) {
    is Relative -> Trigger(
        offset.toBiweeklyDuration(),
        related.toBiweeklyValue(),
    )

    is Absolute -> Trigger(
        ICalDate(time),
    )
}
