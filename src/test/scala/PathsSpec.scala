import org.scalatest.{BeforeAndAfter, FunSpec}

class PathsSpec extends FunSpec with BeforeAndAfter {
  var graph: Graph = _
  var paths: Paths = _

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

  describe("hasPathTo") {
    it("has a path within the small cluster") {
      paths = new Paths(graph, Vertex(7))

      assert(paths.hasPathTo(Vertex(8)))
    }

    it("has a path within the large cluster") {
      paths = new Paths(graph, Vertex(0))

      assert(paths.hasPathTo(Vertex(4)))
    }

    it("has a path within the medium cluster") {
      paths = new Paths(graph, Vertex(12))

      assert(paths.hasPathTo(Vertex(9)))
    }

    it ("does not have a path between the large and small clusters") {
      paths = new Paths(graph, Vertex(0))

      assert(!paths.hasPathTo(Vertex(7)))
    }

    it ("does not have a path between the large and medium clusters") {
      paths = new Paths(graph, Vertex(11))

      assert(!paths.hasPathTo(Vertex(6)))
    }
  }

  describe("pathTo") {
    it("is the path between vertex 0 and 4") {
      paths = new Paths(graph, Vertex(0))

      assert(paths.pathTo(Vertex(4)) == Seq(Vertex(4), Vertex(3), Vertex(5), Vertex(0)))
    }

    it("has no path") {
      paths = new Paths(graph, Vertex(0))

      assert(paths.pathTo(Vertex(11)) == Seq())
    }
  }
}
