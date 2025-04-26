Buffering
buffering_
Invisible

Buffering — 2:33 PM
Have you made progress on the project?
teriyaki — 2:38 PM
yoo, i am struggling with it quite a bit since im ass at coding. im usins AI and shit but getting lost lmao. Has ryan reached out at all
Buffering — 2:40 PM
No he hasn’t
teriyaki — 2:40 PM
damn i feel like he dropped the class or something
Buffering — 2:40 PM
Maybe
Part 2 should be done by tomorrow and I’ll see how much we can do with part 3
If we aren’t close by Monday I’ll just ask for an extension i guess
teriyaki — 2:44 PM
how have you been doing the first 2 questions? are you coding it yourself?
Buffering — 2:44 PM
Yea
With ai help when I get stuck
teriyaki — 2:46 PM
good shit i think im gonna have to change majors lmao. I'm gonna try to get more work done tonight and see how far i can get
ill try to reach out to ryan too
Buffering — 2:48 PM
Alright
teriyaki — 2:57 PM
did the pull request work ? not sure if i did it correctly
Image
this is what i had for this one, but when i look at github i only see like 2 lines
Buffering — 3:00 PM
Yea there’s only 2 lines on GitHub
teriyaki — 3:01 PM
do you mind if i sent you the code to copy paste into each file?
w.e ur free
Buffering — 3:02 PM
You can
teriyaki — 3:02 PM
ight
Buffering — 3:02 PM
Just drag and drop the files into discord
teriyaki — 3:02 PM
true
Buffering — 3:02 PM
That should work
teriyaki — 3:07 PM
import java.util.ArrayList;
import java.util.List;

public class EntityNode {
private String name;
private List<RelationEdge> relations;
Expand
EntityNode.java
1 KB
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

public class GraphVisualizer {
    public static void display(KnowledgeGraph knowledgeGraph) {
        System.setProperty("org.graphstream.ui", "swing");
Expand
GraphVisualizer.java
2 KB
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.util.*;

public class KnowledgeGraph {
    private Map<String, EntityNode> entities;
Expand
KnowledgeGraph.java
3 KB
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
Collapse
KnowledgeGraphApp.java
3 KB
public class RelationEdge {
    private String relationType;
    private EntityNode source;
    private EntityNode destination;

    public RelationEdge(String relationType, EntityNode source, EntityNode destination) {
Expand
RelationEdge.java
1 KB
﻿
teriyaki
easyace.
 
 
 
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.util.*;

public class KnowledgeGraph {
    private Map<String, EntityNode> entities;
    private Map<String, List<RelationEdge>> relations;

    public KnowledgeGraph() {
        entities = new HashMap<>();
        relations = new HashMap<>();
    }

    public void buildGraph(String filePath) {
        try {
            Workbook workbook = WorkbookFactory.create(new File(filePath));
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                String entity1 = row.getCell(0).getStringCellValue();
                String relation = row.getCell(1).getStringCellValue();
                String entity2 = row.getCell(2).getStringCellValue();

                EntityNode node1 = entities.computeIfAbsent(entity1, EntityNode::new);
                EntityNode node2 = entities.computeIfAbsent(entity2, EntityNode::new);

                RelationEdge edge = new RelationEdge(relation, node1, node2);
                node1.addRelation(edge);
                node2.addRelation(edge);

                relations.computeIfAbsent(relation, k -> new ArrayList<>()).add(edge);
            }

            workbook.close();
        } catch (Exception e) {
            System.err.println("Error reading Excel file: " + e.getMessage());
        }
    }
