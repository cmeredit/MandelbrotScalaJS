package tutorial.webapp

case class Complex(real: Double, imag: Double) {
  def +(other: Complex): Complex = Complex(real + other.real, imag + other.imag)
  def -(other: Complex): Complex = Complex(real - other.real, imag - other.imag)
  def *(other: Complex): Complex = Complex(real * other.real - imag * other.imag, real * other.imag + imag * other.real)
  def magnitudeSquared: Double = real * real + imag * imag
}
