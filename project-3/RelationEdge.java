public class RelationEdge {
    private String relationType;
    private EntityNode source;
    private EntityNode destination;

    public RelationEdge(String relationType, EntityNode source, EntityNode destination) {
        this.relationType = relationType;
        this.source = source;
        this.destination = destination;
    }

    public String getRelationType() {
        return relationType;
    }

    public EntityNode getSource() {
        return source;
    }

    public EntityNode getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return source + " --" + relationType + "--> " + destination;
    }
}
