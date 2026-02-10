package top.ltfan.omnical.icalendar.biweekly

import biweekly.util.DayOfWeek as BiweeklyDayOfWeek
import kotlinx.datetime.DayOfWeek as KotlinDayOfWeek

/** Converts a [BiweeklyDayOfWeek] to a [KotlinDayOfWeek]. */
@Suppress("NOTHING_TO_INLINE")
inline fun BiweeklyDayOfWeek.toKotlinDayOfWeek(): KotlinDayOfWeek = when (this) {
    MONDAY -> MONDAY
    TUESDAY -> TUESDAY
    WEDNESDAY -> WEDNESDAY
    THURSDAY -> THURSDAY
    FRIDAY -> FRIDAY
    SATURDAY -> SATURDAY
    SUNDAY -> SUNDAY
}

/** Converts a [KotlinDayOfWeek] to a [BiweeklyDayOfWeek]. */
@Suppress("NOTHING_TO_INLINE")
inline fun KotlinDayOfWeek.toBiweeklyValue(): BiweeklyDayOfWeek = when (this) {
    MONDAY -> MONDAY
    TUESDAY -> TUESDAY
    WEDNESDAY -> WEDNESDAY
    THURSDAY -> THURSDAY
    FRIDAY -> FRIDAY
    SATURDAY -> SATURDAY
    SUNDAY -> SUNDAY
}
