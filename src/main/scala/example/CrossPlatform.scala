package example

import java.util.Random
//import com.typesafe.scalalogging.Logger
import org.slf4j.Logger
import org.slf4j.LoggerFactory

trait CrossPlatform {
  val logger: Logger = LoggerFactory.getLogger("Predict.scala")
  var nrows: Int = 0
  var arrInArr: Array[Array[Int]] = Array.empty[Array[Int]]

//
  val fake: Int=0
  logger.info("how old are you?")
}

class PassArgs extends CrossPlatform {

  def passIntFromJava(intArray: Array[Int]): Unit = {
    logger.info(intArray.mkString(", "))
  }

  def getArrInArr(which_row: Int): Array[Int] = arrInArr(which_row)

  def setArrInArr(): Unit = {
    val rd = new Random()
    val rows = rd.nextInt(1000) % 10 + 1
    val cols = rd.nextInt(1000) % 3 + 1
    var tmp: Int = -999
    var for_each_row: String = ""

    nrows = rows
    for (i <- 0 to rows - 1) {
      arrInArr :+= Array.empty[Int]
      for_each_row = s"row ${i}: "
      for (j <- 0 to cols - 1) {
        tmp = rd.nextInt(1000)
        arrInArr(i) :+= tmp
        for_each_row += s"${tmp}, "
      }
      println(for_each_row)
//      for_each_row += "\n"
      logger.info(for_each_row)
    }

  }
}


object test extends App {
  val PA = new PassArgs()
  PA.passIntFromJava(Array(1, 2, 3))
  PA.setArrInArr()
  var the_last_row = PA.getArrInArr(PA.nrows - 1)
  the_last_row.map(println)
  the_last_row :+= 100
  PA.getArrInArr(PA.nrows - 1).map(println)
}