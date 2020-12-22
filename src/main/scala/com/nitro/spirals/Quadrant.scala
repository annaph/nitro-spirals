package com.nitro.spirals

sealed trait Quadrant {

  def level: Level

  def positionInQuadrant(elementValue: Long): Long =
    (elementValue - level.firstLocation.value) % level.numberOfElementsPerQuadrant

}

case object ZeroQuadrant extends Quadrant {

  override def level: Level = Level(
    value = 0,
    numberOfElements = 1,
    firstLocation = Location(1, 0, 0),
    lastLocation = Location(1, 0, 0),
    numberOfElementsPerQuadrant = 0)

}

case class Right(level: Level) extends Quadrant

case class Top(level: Level) extends Quadrant

case class Left(level: Level) extends Quadrant

case class Bottom(level: Level) extends Quadrant

object Quadrant {

  def apply(level: Level, elementValue: Long): Quadrant =
    if (level.value == 0) ZeroQuadrant else {
      val quadrantIndex = (elementValue - level.firstLocation.value) / level.numberOfElementsPerQuadrant
      quadrantIndex match {
        case 0 =>
          Right(level)
        case 1 =>
          Top(level)
        case 2 =>
          Left(level)
        case 3 =>
          Bottom(level)
        case _ =>
          throw new Exception("Cannot determine quadrant!")
      }
    }

}
