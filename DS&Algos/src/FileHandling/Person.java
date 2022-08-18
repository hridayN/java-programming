package FileHandling;

public class Person {
    private String Name;
    private FileDemo.RelationType Relation;
    private String ContactNumber;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public FileDemo.RelationType getRelation() {
        return Relation;
    }

    public void setRelation(FileDemo.RelationType relation) {
        Relation = relation;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }
}
