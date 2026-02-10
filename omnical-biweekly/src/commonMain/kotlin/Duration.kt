package top.ltfan.omnical.icalendar.biweekly

import kotlin.time.Duration.Companion.milliseconds
import biweekly.util.Duration as BiweeklyDuration
import kotlin.time.Duration as KotlinDuration

/** Converts a [BiweeklyDuration] to a [KotlinDuration]. */
@Suppress("NOTHING_TO_INLINE")
inline fun BiweeklyDuration.toKotlinDuration() = toMillis().milliseconds

/** Converts a [KotlinDuration] to a [BiweeklyDuration]. */
@Suppress("NOTHING_TO_INLINE")
inline fun KotlinDuration.toBiweeklyDuration(): BiweeklyDuration = BiweeklyDuration.fromMillis(inWholeMilliseconds)
