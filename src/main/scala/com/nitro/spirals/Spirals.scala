package com.nitro.spirals

import com.nitro.spirals.Spirals.findLocation

/**
 * See README.md for solution description.
 *
 */
object SpiralsApp extends App {
  // Extract element value form args
  val elementValue = extractElementValue(args)

  // find location
  val location = findLocation(elementValue)
  println(location)

  println(s"===> Distance for '$elementValue' is: ${location.distance}")

}

object Spirals {

  def findLocation(elementValue: Long): Location = {
    // find level
    val level = Level(elementValue)

    // find quadrant
    val quadrant = Quadrant(level, elementValue)

    // find element
    val element = Element(quadrant, elementValue)
    //println(element)

    element.location
  }

}
