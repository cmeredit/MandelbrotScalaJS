package tutorial.webapp

case class Orbit(orb: Vector[Complex])

class MandelbrotGenerator(val maxIterations: Int) {

  def getIterations(original: Complex): (Int, Complex) = {
    //    if (iterations <= 0 || z.magnitudeSquared >= 4.0) (0, z)
    //    else {
    //      val rec = getIterations(z * z + original, original, iterations - 1)
    //      (rec._1 + 1, rec._2)
    //    }

    var x = 0.0
    var y = 0.0
    var iteration = 0
    while (x*x + y*y <= 4.0 && iteration < maxIterations) {
      val xtemp = x*x - y*y + original.real
      y = 2.0*x*y + original.imag
      x = xtemp
      iteration = iteration + 1
    }
    (iteration, Complex(x, y))
  }

  def getOrbit(z: Complex): Orbit = {

    lazy val lazyOrbit: LazyList[Complex] = z #:: lazyOrbit.map(c => c*c*c*c+z)

    Orbit(lazyOrbit.zipWithIndex.takeWhile(p => p._1.magnitudeSquared <= 4.0 && p._2 < maxIterations).map(_._1).toVector)

  }

}
