class Point(xc: Int, yc: Int) {
  var x: Int = xc
  var y: Int = yc

  def move(dx: Int, dy: Int) = {
    x += dx
    y += dy
  }

  def reset() = {
    x = 0
    y = 0
  }
  def copy(): Point = new Point(x,y)

  override def toString: String = "(" + x + ", " + y + "), width=" + width

  def width = x + y
}

class Circle(cCenter: Point, cRadius: Int) {
  val center: Point = cCenter
  val radius: Int = cRadius

  override def toString: String = center.toString() + " radius=" + radius.toString
}

class Drawing {
  def draw() = {

    val pt = new Point(1, 2)
    println(pt)
    pt.move(10, 10)
    println(pt)
    val pt2 = pt copy;
    val pt3 = pt.copy(); // same as above but different syntax
    pt.reset()
    println("pt = "+pt)
    println("pt2 = "+pt2)
    println("pt3 = "+pt3)
    pt3.move(1,3)
    println("pt3 = "+pt3)
    pt.move(5, 3)
    println(pt)

    val c = new Circle(pt, 3)
    c.center.x = 5
    c.center.y = 4
    println(c)
  }
}

object Classes {
  def main(args: Array[String]): Unit = {
    new Drawing().draw()
  }
}