package top.ltfan.omnical.icalendar

import kotlinx.serialization.Serializable

/**
 * Represents the "PRIORITY" property of an iCalendar component as defined
 * in
 * [RFC 5545 Section 3.8.1.9](https://datatracker.ietf.org/doc/html/rfc5545#section-3.8.1.9).
 *
 * In the iCalendar format:
 * - `0` indicates an undefined priority.
 * - `1` is the highest priority.
 * - `9` is the lowest priority.
 *
 * @property value The raw unsigned byte value (0-9) as stored in the
 *   iCalendar data.
 */
@Serializable
enum class ICalendarPriority(val value: UByte) {
    None(0u),
    P1(1u),
    P2(2u),
    P3(3u),
    P4(4u),
    P5(5u),
    P6(6u),
    P7(7u),
    P8(8u),
    P9(9u);

    companion object {
        private val valueMap by lazy { entries.associateBy(ICalendarPriority::value) }

        /**
         * Returns the [ICalendarPriority] instance corresponding to the given
         * [UByte] value.
         *
         * @param value A value from 0u to 9u.
         * @return The matching [ICalendarPriority], or `null` if the value is out
         *   of range.
         */
        fun fromValue(value: UByte) = valueMap[value]
    }

    /**
     * A value suitable for sorting or comparison logic.
     *
     * Per RFC 5545, a value of `0` (None) is logically considered less
     * prioritized than `9`. This property maps [None] to `10u` so that a
     * simple ascending sort correctly puts higher priorities first and [None]
     * last.
     */
    val comparableValue by lazy { value.takeIf { it in 1u..9u } ?: 10u }
}
