package com.nitro.spirals

import com.nitro.spirals.Element._

case class Element(quadrant: Quadrant, value: Long) {

  def location: Location = quadrant match {
    case ZeroQuadrant =>
      ZeroQuadrant.level.firstLocation
    case right: Right =>
      findInRightQuadrant(right, value)
    case top: Top =>
      findInTopQuadrant(top, value)
    case left: Left =>
      findInLeftQuadrant(left, value)
    case bottom: Bottom =>
      findInBottomQuadrant(bottom, value)
  }

}

object Element {

  private[spirals] def findInRightQuadrant(right: Right, elementValue: Long): Location = {
    val level = right.level
    val positionInQuadrant = right positionInQuadrant elementValue

    Location(
      value = elementValue,
      row = level.firstLocation.row - positionInQuadrant,
      column = level.value)
  }

  private[spirals] def findInTopQuadrant(top: Top, elementValue: Long): Location = {
    val level = top.level
    val positionInQuadrant = top positionInQuadrant elementValue

    Location(
      value = elementValue,
      row = level.value * -1,
      column = level.firstLocation.column - 1 - positionInQuadrant)
  }

  private[spirals] def findInLeftQuadrant(left: Left, elementValue: Long): Location = {
    val level = left.level
    val positionInQuadrant = left positionInQuadrant elementValue

    Location(
      value = elementValue,
      row = level.firstLocation.row + 1 - level.numberOfElementsPerQuadrant + 1 + positionInQuadrant,
      column = level.value * -1)
  }

  private[spirals] def findInBottomQuadrant(bottom: Bottom, elementValue: Long): Location = {
    val level = bottom.level
    val positionInQuadrant = bottom positionInQuadrant elementValue

    Location(
      value = elementValue,
      row = level.value,
      column = level.firstLocation.column - level.numberOfElementsPerQuadrant + 1 + positionInQuadrant)
  }

}
