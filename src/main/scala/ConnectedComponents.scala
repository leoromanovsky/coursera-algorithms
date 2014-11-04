

// Maximal set of connected vertices.
class ConnectedComponents(g: Graph) {
  var marked:Map[Vertex,Boolean] = Map()
  var x = 0
  g.vertices.foreach(v =>
    marked += (v -> false)
  )

  println("init", marked)

  buildIndex

  def connected(from: Vertex, to: Vertex): Boolean = {

    false
  }

  def count(): Int = {

    0
  }

  private

  def buildIndex {

  }
}
