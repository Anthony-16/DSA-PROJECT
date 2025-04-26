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

    public List<String> getEntityRelations(String entityName) {
        if (!entities.containsKey(entityName)) {
            return Collections.emptyList();
        }
        return entities.get(entityName).getRelations().stream()
                .map(RelationEdge::getRelationType)
                .distinct()
                .toList();
    }

    public List<String[]> getRelationPairs(String relationType) {
        if (!relations.containsKey(relationType)) {
            return Collections.emptyList();
        }
        return relations.get(relationType).stream()
                .map(edge -> new String[]{edge.getSource().getName(), edge.getDestination().getName()})
                .toList();
    }

    public String navigate(String entityName, String relationType) {
        if (!entities.containsKey(entityName)) {
            return null;
        }

        for (RelationEdge edge : entities.get(entityName).getRelations()) {
            if (edge.getRelationType().equals(relationType)) {
                return edge.getSource().getName().equals(entityName) ?
                        edge.getDestination().getName() : edge.getSource().getName();
            }
        }
        return null;
    }

    public Collection<EntityNode> getEntities() {
        return entities.values();
    }

    public Collection<List<RelationEdge>> getRelations() {
        return relations.values();
    }
}
