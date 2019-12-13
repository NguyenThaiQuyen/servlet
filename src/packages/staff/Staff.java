package packages.staff;
public class Staff {
    /**
     *
     */
    private String id;
    private String fullName;
    private String gender;
    private String idPosition;
    private String position;
    private String idDepartment;
    private String department;

    public Staff(
            String _id,
            String _fullName,
            String _gender,
            String _idPosition,
            String _position,
            String _department,
            String _idDepartment) {
        this.id = _id;
        this.fullName = _fullName;
        this.gender = _gender;
        this.idPosition = _idPosition;
        this.position = _position;
        this.department = _department;
        this.idDepartment = _idDepartment;
    }

    public Staff(
            String _id,
            String _fullName,
            String _gender,
            String _idPosition,
            String _idDepartment) {
        this.id = _id;
        this.fullName = _fullName;
        this.gender = _gender;
        this.idPosition = _idPosition;
        this.idDepartment = _idDepartment;
    }

    public Staff(
            String _fullName,
            String _gender,
            String _idPosition,
            String _idDepartment) {
        this.fullName = _fullName;
        this.gender = _gender;
        this.idPosition = _idPosition;
        this.idDepartment = _idDepartment;
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

    public void setIdPosition(String _idPosition) {
        this.idPosition = _idPosition;
    }

    public String getIdPosition() {
        return idPosition;
    }

    public void setIdDepartment(String _idDepartment) {
        this.idDepartment = _idDepartment;
    }
    public String getIdDepartment() {
        return idDepartment;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}