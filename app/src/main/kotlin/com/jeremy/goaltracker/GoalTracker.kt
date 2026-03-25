package com.jeremy.goaltracker

import java.io.File
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.FileReader
import java.io.FileWriter
import java.io.IOException
import java.time.LocalDate
import com.jeremy.goaltracker.DateFormats as Format // DATE_FORMAT
import com.jeremy.goaltracker.AnsiStyles as Ansi // PURPLE, RED, RESET
import com.jeremy.goaltracker.GoalTimePeriod

class GoalTracker {

    private val goals: MutableList<Goal> = mutableListOf()
    private val FILE_NAME = "goals.txt"
    private var topId = 0
    
    // Function to keep id numbering correct
    private fun getListTopId() {
        topId = goals.maxOfOrNull { it.id } ?: 0
    }

    fun addGoal(timePeriod: GoalTimePeriod, label: String, description: String, startDate: LocalDate, endDate: LocalDate, priority: Int) {
        topId += 1
        goals.add(Goal(timePeriod, label, description, startDate, endDate, priority, id = topId))
        goals.sort()
    }

    fun toggleCompleteStatus(id: Int) {
        val toggleGoal = goals.find { it.id == id }

        if (toggleGoal == null) {
            println("${Ansi.RED}Invalid goal ID.${Ansi.RESET}")
            return
        } 
                
        toggleGoal.completed = !toggleGoal.completed
        println("Goal status set to ${Ansi.PURPLE}${if (toggleGoal.completed) "Done [X]" else "Pending [ ]"}${Ansi.RESET}")    
    }

    fun listAllGoals() {
        if (goals.isEmpty()) {
            println("${Ansi.RED}No goals found.${Ansi.RESET}")
            return
        }

        val maxLength = GoalTimePeriod.entries.maxOf { it.name.length }

        goals
            .sorted()
            .groupBy { it.goalTimePeriod }
            .forEach { (category, group) ->

                val paddedCategory = category.name.padEnd(maxLength)

                println("\n=== $paddedCategory GOALS ===")

            var lastStartDate: LocalDate? = null
            group.sortedBy { it.goalStartDate }.forEachIndexed { index, goal ->
                // Only print the category arrow if the start date is new
                val categoryLabel = if (goal.goalStartDate != lastStartDate) {
                    lastStartDate = goal.goalStartDate
                    "$paddedCategory ->"
                } else {
                    " ".repeat(paddedCategory.length + 3) // align with arrow
                }
                println("$categoryLabel ${index + 1}) $goal")
            }
            }
    }

    fun listGoalSummary(timePeriod: GoalTimePeriod, startDate: LocalDate): List<Goal> {
        val filtered = goals.filter { 
            it.goalTimePeriod == timePeriod && it.goalStartDate == startDate 
        }

        if (filtered.isEmpty()) {
            println("${Ansi.RED}No goals found.${Ansi.RESET}")
            return emptyList()
        }

        filtered.forEachIndexed { i, goal ->
            println("${i + 1}) ${goal.goalTimePeriod} (${goal.goalStartDate} - ${goal.goalEndDate}) | ${goal.goalLabel} | ${if (goal.completed) "Done [X]" else "Pending [ ]"}")
        }

        return filtered
    }

    fun listGoalsByCategory(category: GoalTimePeriod) {
        val found = goals
            .filter { it.goalTimePeriod == category }
            .sorted()

        if (found.isEmpty()) {
            println("${Ansi.RESET}${Ansi.RED}No goals in $category timeframe.${Ansi.RESET}")
        } else {
            val paddedCategory = category.name.padEnd(
                GoalTimePeriod.entries.maxOf { it.name.length }
            )

            println("\n=== $paddedCategory GOALS ===${Ansi.RESET}")

            var lastStartDate: LocalDate? = null
            found.forEachIndexed { index, goal ->
                // Only print the category arrow if the start date is new
                val categoryLabel = if (goal.goalStartDate != lastStartDate) {
                    lastStartDate = goal.goalStartDate
                    "$paddedCategory ->"
                } else {
                    " ".repeat(paddedCategory.length + 3) // align with arrow
                }
                println("$categoryLabel ${index + 1}) $goal")
            }
        }
    }

    fun deleteGoalById(id: Int) {
        val removed = goals.removeIf { it.id == id }    
    }

    @Throws(IOException::class)
    fun saveToFile() {
        BufferedWriter(FileWriter(FILE_NAME)).use { writer ->
            goals.forEach { writer.write(it.toFileString()); writer.newLine() }
        }
    }

    @Throws(IOException::class)
    fun loadFromFile() {
        val file = File(FILE_NAME)
        if (!file.exists()) return

        BufferedReader(FileReader(file)).use { reader ->
            goals.clear()
            reader.lineSequence().forEach { goals.add(Goal.fromFileString(it)) }
            goals.sort()
        }
    }
}