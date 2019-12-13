package packages.staff;
public class Staff {
    /**
     *
     */
    private String id;
    private String fullName;
    private String gender;
    private String position;
    private String department;

    public Staff(
            String _id,
            String _fullName,
            String _gender,
            String _position,
            String _department) {
        this.id = _id;
        this.fullName = _fullName;
        this.gender = _gender;
        this.position = _position;
        this.department = _department;
    }

    public Staff(
            String _fullName,
            String _gender,
            String _position,
            String _department) {
        this.fullName = _fullName;
        this.gender = _gender;
        this.position = _position;
        this.department = _department;
    }

    public String getID() {
        return id;
    }

    public void setFullName(String _fullName) {
        this.fullName = _fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setGender(String _gender) {
        this.gender = _gender;
    }

    public String getGender() {
        return gender;
    }

    public void setPosition(String _position) {
        this.position = _position;
    }

    public String getPosition() {
        return position;
    }

    public void setDepartment(String _department) {
        this.department = _department;
    }
    public String getDepartment() {
        return department;
    }




}