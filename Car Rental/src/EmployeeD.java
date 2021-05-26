public class EmployeeD {

    private String name;
   private String salary;
   private String id;
   private String password;
   private String position;

    public EmployeeD(String name, String salary, String id, String password, String position) {
        this.name = name;
        this.salary = salary;
        this.id = id;
        this.password = password;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String toString(){

        return id;
    }
}