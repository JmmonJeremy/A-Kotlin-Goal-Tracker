# Kotlin Goal Tracker

This is a Kotlin program for tracking personal goals under the time categories of  LIFETIME, DECADE, YEARLY, MONTHLY, WEEKLY, and DAILY. The program runs in the terminal. The program has a main menu that allows you to add goals, list all goals, list goals under a specific time category, mark goals as completed, and remove goals. 

## Instructions for Build and Use

[Software Demo](https://youtu.be/8GDaINPE4go)

Steps to build and/or run the software:

1. Go to the website https://code.visualstudio.com/ and click on the "Download for Windows" button to install.
2. Go to the website https://adoptium.net/ and install JDK 17 LTS
3. Go to the website https://gradle.org/releases/ and Download the binary-only zip & add the path to gradle-9.4.0\bin in Environment Variables → System variables → Path → Edit → New
4. Run the command ./gradlew build inside the project's folder to create a Gradle Wrapper
5. Got to VS Code's EXTENSION tool and install Gradle for Java by Microsoft, Kotlin Language by mathiasfrohlich, and Kotlin by fwcd
6. Then in VS Code enter CTRL + SHIFT + P and enter Preferences: Open Workspace Settings (JSON) to open the settings.json file and add "kotlin.diagnostics.enabled": false
7. I included the .vscode folder with the settings.json file in the repository so that you can have all the settings associated with the extensions - the one above is the most important
8. Go to the website https://github.com/JetBrains/kotlin/releases and download the Command-line compiler (Windows .zip) - kotlin-compiler-2.3.20.zip & add the path to kotlinc\bin in Environment Variables → System variables → Path → Edit → New
9. Put the code files of App.kt, DateFormatAndAnsiStyles.kt, Goal.kt, GoalTimePeriod.kt, and GoalTracker.kt in place in the app/src/main/kotlin/<etc.> folder and the AppTest.kt in the app/src/test/kotlin/<etc.>
10. Replace packagename with a proper package for you by replacing the package import in the files to com.<your name>.goaltracker,change the folder path where I put etc with com/<your name>/goaltracker, move all the files into that folder, and do the same for the AppTest.kt file.
11. Open app/build.gradle.kts, find the application { mainClass = "<etc.>" } section and change it to application { mainClass = "com.<your name>.goaltracker.AppKt" }
12. To run the program enter the command .\gradlew run --console=plain the program, to run the test enter .\gradlew test, to rerun a test enter .\gradlew test --rerun-tasks, and if issues to clear out issues enter .\gradlew clean

Instructions for using the software:

1. With VS Code open the A Kotlin Goal Tracker folder or whatever you name your folder holding the Kotlin project
2. In the terminal for VS Code enter the command .\gradlew run --console=plain to start the program
3. User the terminal to enter selections of Add goal, View all goals, View goals by timeframe, Change goal status, Remove a goal, and Exit

## Development Environment

To recreate the development environment, you need the following software and/or libraries with the specified versions:

* Visual Studio Code
* JDK 17 LTS
* Gradle
* Gradle for Java Extension by Microsoft
* Kotlin (kotlin-compiler-2.3.20)
* Kotlin Language Extension by mathiasfrohlich
* Kotlin Extension by fwcd
* ANSI Escape Sequences
* Git / GitHub

## Useful Websites to Learn More

I found these websites useful in developing this software:

### Visual Studio Code :
* [Visual Studio Code & GitHub](https://code.visualstudio.com/docs/sourcecontrol/overview)
* [Installing the Extension Pack for Java](https://code.visualstudio.com/docs/languages/java)
* [VS Code Java build tools Docs](https://code.visualstudio.com/docs/java/java-build)
* [VS Code & Gradle Docs](https://docs.gradle.org/current/userguide/gradle_ides.html#visual_studio_code)
* [VS Code Gradle for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-gradle)
* [VS Code Kotlin IDE](https://marketplace.visualstudio.com/items?itemName=fwcd.kotlin)
* [Configure VS Code to Debug a Gradle/Kotlin Project](https://stackoverflow.com/questions/75418906/how-to-configure-vscode-to-debug-a-gradle-kotlin-project)
* [Debugging Kotlin program using VSCode](https://medium.com/@thunderz99/debugging-kotlin-program-using-vscode-318ed43fe2f0)
* [Learning Kotlin: Programming with VS Code](https://dev.to/mwrpwr/learning-kotlin-programming-with-visual-studio-code-5e29)
* [Running Gradle from VS Code](https://www.syncfusion.com/succinctly-free-ebooks/gradle-succinctly/running-gradle-from-visual-studio-code)

### Gradle :
* [Installing Gradle Docs](https://docs.gradle.org/current/userguide/installation.html)
* [Gradle Overview Docs](https://kotlinlang.org/docs/gradle.html)
* [Get Started with Gradle and Kotlin Docs](https://kotlinlang.org/docs/get-started-with-jvm-gradle-project.html)
* [Configure a Gradle Project Docs](https://kotlinlang.org/docs/gradle-configure-project.html)
* [Building Kotlin Applications Sample Docs](https://docs.gradle.org/current/samples/sample_building_kotlin_applications.html)
* [Building Kotlin Applications with Libraries Docs](https://docs.gradle.org/current/samples/sample_building_kotlin_applications_multi_project.html)
* [Gradle Fundamentals](https://tomgregory.com/gradlebuildbible)
* [Setting up Gradle with Kotlin](https://dispatchersdotplayground.hashnode.dev/setting-up-gradle-with-kotlin-dsl-a-simple-guide)
* [Using Gradle with Kotlin](https://medium.com/@AlexanderObregon/using-gradle-with-kotlin-dsl-a-step-by-step-guide-65a70955edc8)

### Kotlin :
* [Comparison to Java Docs](https://kotlinlang.org/docs/comparison-to-java.html)
* [Java LocalDate](https://beginnersbook.com/2017/10/java-localdate/)
* [Java LocalDate – equals()](https://beginnersbook.com/2017/10/java-localdate-equals/)
* [Java Colored Console Text](https://www.geeksforgeeks.org/java/how-to-print-colored-text-in-java-console/)
* [Java ANSI Code Constants](https://www.tutorialspoint.com/how-to-print-colored-text-in-java-console)
* [Class TemporalAdjusters Oracle Docs](https://docs.oracle.com/javase/8/docs/api/java/time/temporal/TemporalAdjusters.html)
* [TemporalAdjuster in Java](https://www.baeldung.com/java-temporal-adjuster)
* [ANSI Escape Sequences](https://gist.github.com/fnky/458719343aabd01cfb17a3a4f7296797)
* [Basic syntax overview Docs](https://kotlinlang.org/docs/basic-syntax.html)
* [Learn Kotlin Programming Tutorials](https://www.programiz.com/kotlin-programming)
* [Kotlin Tutorial](https://www.w3schools.com/kotlin/index.php)
* [Work with Dates and Time in Kotlin](https://medium.com/@juricavoda/how-to-work-with-dates-and-time-in-kotlin-with-the-java-time-api-14767ed9c6f2)
* [Get Days of Week Using Kotlin](https://stackoverflow.com/questions/70855240/how-do-i-get-the-days-of-the-week-using-kotlin-in-android-studio)
* [Kotlin Standard input Docs](https://kotlinlang.org/docs/standard-input.html)
* [Kotlin print(), println(), readLine(), Scanner, REPL Tutorial](https://www.digitalocean.com/community/tutorials/kotlin-print-println-readline-scanner-repl)
* [JvmStatic, JvmOverloads, and JvmField in Kotlin](https://www.geeksforgeeks.org/kotlin/jvmstatic-jvmoverloads-and-jvmfield-in-kotlin/?utm_source=chatgpt.com)
* [The @JvmStatic Annotation in Kotlin](https://www.baeldung.com/kotlin/jvmstatic-annotation)
* [Kotlin when expression](https://www.geeksforgeeks.org/kotlin/kotlin-when-expression/)
* [Kotlin When Tutorial](https://www.w3schools.com/kotlin/kotlin_when.php)
* [Kotlin when Expression Tutorial](https://www.programiz.com/kotlin-programming/when-expression)
* [Guide to the “when{}” Block in Kotlin](https://www.baeldung.com/kotlin/when)
* [Kotlin Regex](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/-regex/)
* [Regular Expressions in Kotlin](https://www.baeldung.com/kotlin/regular-expressions)
* [Kotlin Regular Expression](https://www.geeksforgeeks.org/kotlin/kotlin-regular-expression/)
* [Kotlin List - map() Function](https://www.tutorialspoint.com/kotlin/kotlin_list_map_function.htm)
* [Kotlin Ranges Docs](https://kotlinlang.org/docs/ranges.html#range)
* [Respect the contract of compareTo](https://kt.academy/article/ek-compareto)
* [How to Repeat a String N Times in Kotlin](https://www.baeldung.com/kotlin/repeating-strings)
* [Kotlin Split](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/split.html)
* [Kotlin Enum Classes Docs](https://kotlinlang.org/docs/enum-classes.html)
* [Writing to a File in Kotlin](https://www.baeldung.com/kotlin/write-file)
* [Read From Files using BufferedReader in Kotlin](https://www.geeksforgeeks.org/kotlin/read-from-files-using-bufferedreader-in-kotlin/)
* [Writing to a File in Kotlin](https://www.baeldung.com/kotlin/write-file)
* [Using Kotlin’s `BufferedWriter` for Efficient File Writing](https://www.slingacademy.com/article/using-kotlins-bufferedwriter-for-efficient-file-writing/)
* [Kotlin Buffered Text Files](https://stonesoupprogramming.com/2017/11/22/kotlin-buffered-text-files/)
* [Guide to Sorting in Kotlin](https://www.baeldung.com/kotlin/sort)
* [Kotlin Grouping Docs](https://kotlinlang.org/docs/collection-grouping.html)
* [Iterating Collections by Index in Kotlin](https://www.baeldung.com/kotlin/iterating-collections-by-index)
* [Filtering a List in Kotlin](https://www.baeldung.com/kotlin/list-filtering)
* [Using the removeIf() Method](https://www.baeldung.com/kotlin/lists-remove-null-empty-values#using-the-removeif-method)
* [https://www.baeldung.com/kotlin/throws-annotation](https://www.baeldung.com/kotlin/throws-annotation)

## Future Work

The following items I plan to fix, improve, and/or add to this project in the future:

* [ ] I will add a menu option and function to be able to modify an existing goal
* [ ] I will add try catch while loop to catch entries besides n or y so that false entries do not cancel for delete and add options
* [ ] I will add coloring to the completion status for goals that are completed when listing out goals
