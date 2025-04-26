import java.util.ArrayList;
import java.util.List;

public class EntityNode {
private String name;
private List<RelationEdge> relations;

public EntityNode(String name) {
this.name = name;
this.relations = new ArrayList<>();
}

public String getName() {
return name;
}

public List<RelationEdge> getRelations() {
return relations;
}

public void addRelation(RelationEdge edge) {
relations.add(edge);
}

@Override
public String toString() {
return name;
}
}
