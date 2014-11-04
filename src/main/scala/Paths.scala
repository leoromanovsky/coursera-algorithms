import scala.collection.mutable.ListBuffer

class Paths(graph: Graph, source: Vertex) {
  var marked:Map[Vertex,Boolean] = Map()
  var edgeTo:Map[Vertex,Vertex] = Map()

  dfs(source)

  // Is there a path from source to destination?
  def hasPathTo(destination: Vertex): Boolean = {
    marked.getOrElse(destination, false)
  }

  // path from source to destination. empty list if no path.
  def pathTo(destination: Vertex): List[Vertex] = {
    if (!hasPathTo(destination)) {
      return List[Vertex]()
    }

    var path = new ListBuffer[Vertex]()
    var x = destination

    while (x != source) {
      path += x

      // TODO: This need to be cleanup.
      x = edgeTo.get(x).get
    }
    path += source

    return path.toList
  }

  private

  def dfs(vertex: Vertex) {
    marked += (vertex -> true)

    graph.adjacency(vertex).foreach { w =>
      if (!marked.getOrElse(w, false)) {
        dfs(w)
        edgeTo += (w -> vertex)
      }
    }
  }

}

object Paths {
  def main(args: Array[String]) {
    val g = new Graph
    g.addEdge(Vertex(0), Vertex(1))
    g.addEdge(Vertex(1), Vertex(2))

    val p = new Paths(g, Vertex(0))
    println(p.hasPathTo(Vertex(2)))
    println(p.pathTo(Vertex(2)))
  }
}
