import scala.collection.mutable.ListBuffer

case class Edge(v: Int, w: Int)

case class Vertex(V: Int)

// 13 (num vertices)
// 13 (num edges)
// 1 2 (pair of edges)

// Adjacency-list graph representation.
// For every vertex, maintain a list of vertices
// that are adjacent to it.
//class Graph(inputStream: List[Edge]) {
class Graph {
  private var adj = new ListBuffer[ListBuffer[Vertex]]()

  def addEdge(v: Vertex, w: Vertex) {
    if (!adj.contains(v.V)) {
      adj += new ListBuffer[Vertex]()
    }
    adj(v.V) += w

    if (!adj.contains(w.V)) {
      adj += new ListBuffer[Vertex]()
    }
    adj(w.V) += v
  }

  def adjacency(v: Vertex): ListBuffer[Vertex] = {
    //println("adjacency", adj(v.V))
    adj(v.V)
  }

  // Travel the adjacency list and discover all unique vertices in the graph.
  def vertices: List[Vertex] = {

    List()
  }

  // Number of vertices connected by an edge
  def degree: Int = {

    0
  }

  // Find biggest degree in the graph
  def maxDegree: Int = {

    0
  }

  //
  def numberOfSelfLoops: Int = {

    0
  }
}

object Graph {
  def main(args: Array[String]) {
    val g = new Graph
    println(g.adjacency(Vertex(0)))
    g.addEdge(Vertex(0), Vertex(1))
    g.addEdge(Vertex(0), Vertex(2))

    println(g.adjacency(Vertex(0)))
  }
}
