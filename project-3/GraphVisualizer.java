import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

public class GraphVisualizer {
    public static void display(KnowledgeGraph knowledgeGraph) {
        System.setProperty("org.graphstream.ui", "swing");
        Graph graph = new SingleGraph("Knowledge Graph");

        // Add all nodes
        knowledgeGraph.getEntities().forEach(entity -> {
            String nodeId = entity.getName();
            graph.addNode(nodeId).setAttribute("ui.label", nodeId);
        });

        // Add all edges
        knowledgeGraph.getRelations().forEach(edges -> {
            edges.forEach(edge -> {
                String edgeId = edge.getSource() + "-" + edge.getRelationType() + "-" + edge.getDestination();
                graph.addEdge(edgeId, edge.getSource().getName(), edge.getDestination().getName(), true)
                        .setAttribute("ui.label", edge.getRelationType());
            });
        });

        graph.display();
    }
}
