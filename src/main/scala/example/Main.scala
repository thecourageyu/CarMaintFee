package example

import sky.yzk.cmf.CarMaintFee

object Main extends App {
  val ages = Seq(42, 75, 29, 64)

  val cmf = CarMaintFee.spendPerKm(1000, 1000, 10)
  println(cmf)
  println(s"The oldest person is ${ages.max}")
}


