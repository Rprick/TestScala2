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

  def copy(): Point = new Point(x, y)

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
    println("Drawing result:")
    println(pt)
    pt.move(10, 10)
    println(pt)
    val pt2 = pt copy;
    val pt3 = pt.copy(); // same as above but different syntax
    pt.reset()
    println("pt = " + pt)
    println("pt2 = " + pt2)
    println("pt3 = " + pt3)
    pt3.move(1, 3)
    println("pt3 = " + pt3)
    pt.move(5, 3)
    println(pt)

    val c = new Circle(pt, 3)
    c.center.x = 5
    c.center.y = 4
    println(c)
  }
}

class CallBacks {
  //Explicit type declaration
  val call1 = doWithOneAndTwo((x: Int, y: Int) => x + y, 3)
  //The compiler expects 2 ints so x and y types are inferred
  val call2 = doWithOneAndTwo((x, y) => x + y, 3, 4)
  //Even more concise syntax
  val call3 = doWithOneAndTwo(_ + _)

  def doWithOneAndTwo(f: (Int, Int) => Int, x: Int = 1, y: Int = 2) = {
    f(x, y)
  }

  def print() {
    println("Callbacks result:")
    println(call1, call2, call3
  }

}

object Classes {
  def main(args: Array[String]): Unit = {
    new Drawing().draw()
    println()
    new CallBacks().print()
  }
}