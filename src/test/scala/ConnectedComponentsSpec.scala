import org.scalatest.{FunSpec, BeforeAndAfter}

class ConnectedComponentsSpec extends FunSpec with BeforeAndAfter {
  var graph: Graph = _
  var connected: ConnectedComponents = _

  before {
    graph = new Graph
    graph.addEdge(Vertex(0), Vertex(1))
    graph.addEdge(Vertex(0), Vertex(2))
    graph.addEdge(Vertex(0), Vertex(5))
    graph.addEdge(Vertex(0), Vertex(6))

    graph.addEdge(Vertex(5), Vertex(3))
    graph.addEdge(Vertex(5), Vertex(4))
    graph.addEdge(Vertex(3), Vertex(4))
    graph.addEdge(Vertex(4), Vertex(6))

    // Isolated cluster
    graph.addEdge(Vertex(7), Vertex(8))

    // Isolated cluster
    graph.addEdge(Vertex(9), Vertex(10))
    graph.addEdge(Vertex(9), Vertex(11))
    graph.addEdge(Vertex(9), Vertex(12))
    graph.addEdge(Vertex(11), Vertex(12))
  }

  describe("connected") {
    it("is connected") {
      connected = new ConnectedComponents(graph)

      assert(connected.connected(Vertex(0), Vertex(4)))
    }

    it("is not connected") {
      connected = new ConnectedComponents(graph)

      assert(!connected.connected(Vertex(0), Vertex(12)))
    }
  }
}
