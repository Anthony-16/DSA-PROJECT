import java.util.Scanner;

public class KnowledgeGraphApp {
    public static void main(String[] args) {
        KnowledgeGraph graph = new KnowledgeGraph();
        graph.buildGraph("Sample-dataset-project.xls");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nKnowledge Graph Explorer");
            System.out.println("1. List all relations for an entity");
            System.out.println("2. List all entity pairs for a relation");
            System.out.println("3. Navigate from entity via relation");
            System.out.println("4. Visualize graph");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter entity name: ");
                    String entity = scanner.nextLine();
                    System.out.println("Relations: " + graph.getEntityRelations(entity));
                    break;
                case 2:
                    System.out.print("Enter relation type: ");
                    String relation = scanner.nextLine();
                    graph.getRelationPairs(relation).forEach(pair ->
                            System.out.println(pair[0] + " <-> " + pair[1]));
                    break;
                case 3:
                    System.out.print("Enter starting entity: ");
                    String startEntity = scanner.nextLine();
                    System.out.print("Enter relation to follow: ");
                    String followRelation = scanner.nextLine();
                    String result = graph.navigate(startEntity, followRelation);
                    System.out.println("Result: " + (result != null ? result : "No connection found"));
                    break;
                case 4:
                    GraphVisualizer.display(graph);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
