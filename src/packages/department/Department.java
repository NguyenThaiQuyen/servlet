package packages.department;

public class Department {
    /**
     *
     */
    private String id;
    private String name;
    private String description;
    private int amount;

    public Department(String _id, String _name, String _description, int _amount) {
        this.id = _id;
        this.name = _name;
        this.description = _description;
        this.amount = _amount;
    }

    public Department(String _id, String _name, String _description) {
        this.id = _id;
        this.name = _name;
        this.description = _description;
    }

    public Department(String _name, String _description) {
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                '}';
    }
}