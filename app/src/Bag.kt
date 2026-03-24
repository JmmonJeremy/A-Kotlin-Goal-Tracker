import java.util.Random

// open is required to be inherited & indicates the class is inheritable
open class Bag(val max_size : Int, val name: String) { // val extends scope without val it only persists in the scope of the class
  
  private val contents = mutableListOf<Int>()

  fun add(item: Int) { // by defalult everything is public so not necessary to specify
    if (contents.size == max_size) return
    contents.add(item)
  }

  open fun remove() : Int? { // open allows this to be overridable in a class that inherits
    if (contents.size == 0) return null
    val random = Random()
    val randIndex = random.nextInt(contents.size)
    val value = contents.removeAt(randIndex)
    return value
  }

  override fun toString() : String {
    return "$name [max=$max_size]: $contents"
  }
}

class LeakyBag(_max_size : Int, _name : String) : Bag(_max_size, _name) { // Is inheriting from bag class and passing in the 2 values

  override fun remove() : Int? { // this is overriding the Bag remove function
    val result = super.remove() // super allows you to call the remove function from Bag
    super.remove() // this is where it is different and "leaking" an item
    return result
  }
}