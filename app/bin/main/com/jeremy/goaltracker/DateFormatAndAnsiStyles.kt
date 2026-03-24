package com.jeremy.goaltracker

import java.time.format.DateTimeFormatter

object DateFormats {
  // Date & Time formatters
    val DATE_FORMAT: DateTimeFormatter = DateTimeFormatter.ofPattern("(EEEE) MMM d, yyyy")    
}

object AnsiStyles {
    // ANSI styles
    const val BOLD = "\u001B[1m"
    const val UNDERLINE = "\u001B[4m"
    const val GREEN = "\u001B[32m"
    const val PURPLE = "\u001B[35m"
    const val RED = "\u001B[31m"    
    const val RESET = "\u001B[0m"
    const val COLOR_RESET = "\u001B[39m"
}