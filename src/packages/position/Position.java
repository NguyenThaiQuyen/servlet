package packages.position;

public class Position {
    /**
     *
     */
    private String id;
    private String name;
    private String description;

    public Position(String _id, String _name, String _description) {
        this.id = _id;
        this.name = _name;
        this.description = _description;
    }

    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String _name) {
        this.name = _name;
    }

    public void setDescription(String _description) {
        this.description = _description;
    }

    public String getDescription() {
        return description;
    }
}