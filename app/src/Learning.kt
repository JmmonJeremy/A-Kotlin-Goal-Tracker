fun getWaterState(temp: Float?) : String? { // question mark allows null
  // rule of thumb is it's best to use immutable when possible (makes it easier to debug)
  // like a switch merged with else if - but can use immutable
  val state = when {
    temp == null -> null // Check for null first
    temp >= 100.0f -> "Gas"
    temp >= 0.0f -> "Liquid"
    else -> "Solid"
  }
  return state
  // above is better way to do what below does - but must use mutable
  var waterState :String?;
  if (temp == null) {
      waterState = null
  } else if (temp >= 100.0f) {
      waterState = "H2O Gas"
  } else if (temp > 0.0f) {
      waterState = "H2O Liquid"
  } else {
      waterState = "H2O Solid"
  }
  return waterState
}

fun main() {
  println("Hello World!")

  val bag = Bag(5, "MyBag")
  bag.add(3)
  bag.add(2)
  bag.add(10)
  bag.add(354)
  bag.add(29)
  bag.add(79)
  println(bag);

  println(bag.remove())
  println(bag.remove())
  println(bag.remove())
  println(bag.remove())
  println(bag.remove())
  println(bag.remove())
  println(bag);

  val leakyBag = LeakyBag(5, "MyLeakyBag")
  leakyBag.add(3)
  leakyBag.add(2)
  leakyBag.add(10)
  leakyBag.add(354)
  leakyBag.add(29)
  leakyBag.add(79)
  println(leakyBag);

  println(leakyBag.remove())
  println(leakyBag.remove())
  println(leakyBag);

  println(getWaterState(50.0f))
  println(getWaterState(-10.5f))
  println(getWaterState(120.9f))
  println(getWaterState(null)) // can't compare null - in Kotlin nothing is allowed to be null unless you specify it's okay

  val w : Int = 5 // immutable (Constant - can't change)
  var x = 7 // mutable (can change) Also if don't type it will autodetect
  val word = "Watermelon"

  x = 6 
  // w = 4 // not allowed
  
  println("w = $w x = $x word = $word")

  val numbers = mutableListOf(1, 2, 3, 4, 5)
  numbers.add(6) // allowed to change the object inside
  //numbers = mutableListOf(10, 20, 30) // not allowed to replace with a different object

  println("numbers = $numbers")
}