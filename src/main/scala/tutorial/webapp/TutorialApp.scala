package tutorial.webapp

import org.scalajs.dom
import org.scalajs.dom.{CanvasRenderingContext2D, document, html}


object TutorialApp {

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
  
  def setupUI(): Unit = {
    val button = document.createElement("button")
    button.textContent = "Click me!"
    button.addEventListener("click", { (e: dom.MouseEvent) =>
      addClickedMessage()
    })
    document.body.appendChild(button)

    appendPar(document.body, "Hello World")
	
	
	type Ctx2D = dom.CanvasRenderingContext2D
	val c: html.Canvas = document.createElement("canvas").asInstanceOf[html.Canvas]
	val ctx = c.getContext("2d").asInstanceOf[Ctx2D]
	
	val w = 300
	c.width = w
	c.height = w
	
	ctx.strokeStyle = "blue"
	ctx.lineWidth = 3
	ctx.beginPath()
	
	ctx.moveTo(w/3, 0)
	ctx.lineTo(w/3, w/3)
	
	ctx.moveTo(w*2/3, 0)
	ctx.lineTo(w*2/3, w/3)
	
	ctx.moveTo(w, w/2)
	ctx.arc(w/2, w/2, w/2, 0, 3.14159)
	
	ctx.stroke()
	
	document.body.appendChild(c)
	
	
  }
  
}