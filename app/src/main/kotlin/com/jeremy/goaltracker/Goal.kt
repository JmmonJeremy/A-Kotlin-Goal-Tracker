package com.jeremy.goaltracker

import java.time.LocalDate
import com.jeremy.goaltracker.DateFormats as Format // DATE_FORMAT
import com.jeremy.goaltracker.AnsiStyles as Ansi // GREEN, RESET
import com.jeremy.goaltracker.GoalTimePeriod

data class Goal(
	val goalTimePeriod: GoalTimePeriod,
    val goalLabel: String,
    val goalDescription: String,    
    val goalStartDate: LocalDate,
    val goalEndDate: LocalDate,
    val goalPriority: Int, // 1-5 - with 1 as highest 5 as lowest priority
	val id: Int,
    var completed: Boolean = false
) : Comparable<Goal> {
    override fun compareTo(other: Goal): Int =
    compareValuesBy(this, other,
		// Order by goalTimePeriod 1st using enum order
        { it.goalTimePeriod },
		// Order by date 2nd 
        { it.goalStartDate },
		// Order so uncompleted goals are on top 3rd
		{ it.completed },
		// Order by priority 4th
		{ it.goalPriority}
    )

    override fun toString(): String {
     	val paddedCategory = goalTimePeriod.name.padEnd(8) // "LIFETIME" = 8 chars
		val indent = "            "  // 12 spaces
		val prefix = "$indent$paddedCategory Goal Details -> "
		val wrapWidth = 115          // choose wrap column (console width)
		val wrapped = wrapTextWithPrefix(description = goalDescription, prefix = prefix, width = wrapWidth)

        return "[${goalStartDate.format(Format.DATE_FORMAT)} - ${goalEndDate.format(Format.DATE_FORMAT)}] | $goalLabel | Priority: ($goalPriority) | ${if (completed) "Done [X]" else "Pending [ ]"}${Ansi.GREEN}\n$wrapped${Ansi.RESET}"
    }

	// helper: manually wraps text
	private fun wrapTextWithPrefix(description: String, prefix: String, width: Int): String {
		val words = description.split(" ")
		val lines = mutableListOf<String>()

		var currentLine = StringBuilder(prefix)   // first line starts with prefix
		var currentLength = prefix.length         // track how long line is

		for (word in words) {
			if (currentLength + word.length + 1 > width) {
				// line full → emit it
				lines.add(currentLine.toString())

				// start new line (indented only)
				currentLine = StringBuilder(" ".repeat(prefix.length))
				currentLength = prefix.length
			}

			// append the word
			if (!currentLine.endsWith(" ")) currentLine.append(" ")
			currentLine.append(word)
			currentLength += word.length + 1
		}

		// add last line
		if (currentLine.isNotEmpty()) {
			lines.add(currentLine.toString())
		}

		return lines.joinToString("\n")
	}

    fun toFileString(): String {
        return "${goalTimePeriod.name}`$goalLabel`$goalDescription`$goalStartDate`$goalEndDate`$goalPriority`$id`$completed"
    }

    companion object {
        fun fromFileString(line: String): Goal {
            val parts = line.split("`")
            val goal = Goal(
				GoalTimePeriod.valueOf(parts[0]),
                parts[1],
                parts[2],                
                LocalDate.parse(parts[3]),
                LocalDate.parse(parts[4]),
                parts[5].toInt(),
				parts[6].toInt(),
                parts[7].toBoolean()
            )
            return goal
        }
    }
}