package tutorial.webapp

import org.scalajs.dom
import org.scalajs.dom.{CanvasRenderingContext2D, document, html}

import scala.util.Random


object TutorialApp {

  type Ctx2D = dom.CanvasRenderingContext2D

  private val randGen: Random = scala.util.Random
  randGen.setSeed(System.currentTimeMillis())

  private object Components {
    val mainCanvas: html.Canvas = document.createElement("canvas").asInstanceOf[html.Canvas]
    val mainCanvasWidth = 300
    mainCanvas.width = mainCanvasWidth
    mainCanvas.height = mainCanvasWidth

    val ctx: Ctx2D = mainCanvas.getContext("2d").asInstanceOf[Ctx2D]
    ctx.strokeStyle = "blue"
    ctx.lineWidth = 3
  }

  def main(args: Array[String]): Unit = {
    document.addEventListener("DOMContentLoaded", { (e: dom.Event) =>
      setupUI()
    })
  }

  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    parNode.textContent = text
    targetNode.appendChild(parNode)
  }

  def addClickedMessage(): Unit = {
    appendPar(document.body, "You clicked the button!")
  }

  def getRandomColorHexString(): String = {
    val r = (0xff * randGen.nextDouble()).toInt.toHexString.toUpperCase()
    val g = (0xff * randGen.nextDouble()).toInt.toHexString.toUpperCase()
    val b = (0xff * randGen.nextDouble()).toInt.toHexString.toUpperCase()
    "#" + r + g + b
  }

  def draw(): Unit = {



    import Components.{ctx, mainCanvasWidth}

    ctx.fillStyle = getRandomColorHexString()
    ctx.fillRect(0, 0, mainCanvasWidth, mainCanvasWidth)

    ctx.strokeStyle = getRandomColorHexString()
    ctx.beginPath()

    ctx.moveTo(mainCanvasWidth/3, 0)
    ctx.lineTo(mainCanvasWidth/3, mainCanvasWidth/3)

    ctx.moveTo(mainCanvasWidth*2/3, 0)
    ctx.lineTo(mainCanvasWidth*2/3, mainCanvasWidth/3)

    ctx.moveTo(mainCanvasWidth, mainCanvasWidth/2)
    ctx.arc(mainCanvasWidth/2, mainCanvasWidth/2, mainCanvasWidth/2, 0, 3.14159)

    ctx.stroke()

  }

  def setupUI(): Unit = {
    val button = document.createElement("button")
    button.textContent = "Click me!"
    button.addEventListener("click", { (e: dom.MouseEvent) =>
      addClickedMessage()
      draw()
    })
    document.body.appendChild(button)

    appendPar(document.body, "Hello, Alexus!")

    import Components.mainCanvas

    draw()

    document.body.appendChild(mainCanvas)

  }
  
}