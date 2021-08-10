public class User {

    class User {
        Integer id; // database entity
        String name;
        Date birthdate;
    }

    public User(String name, Date birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Name: "+this.name+", Birthdate: "+this.birthdate+"\n";
    }
}