package FileHandling;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
public class FileDemo {
    public static void main(String[] args) throws IOException {
        addPerson();
    }

    public static Person createPerson(String name, String contactNumber, RelationType relationType) {
        Person person = new Person();
        person.setName(name);
        person.setContactNumber(contactNumber);
        person.setRelation(relationType);
        return person;
    }

    public static void addPerson() throws IOException {
        // Create a person
        Person person = createPerson("Dumbo", "1111111111", RelationType.Friend);
        String fileName = "";
        switch (person.getRelation()) {
            case Friend:
                fileName.concat(RelationType.Friend.toString());
                break;
            case FamilyMember:
                fileName.concat(RelationType.FamilyMember.toString());
                break;
        }
        File file = new File(fileName + ".txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        raf.writeBytes(person.toString());
        raf.close();
    }

    public enum RelationType {
        Friend,
        FamilyMember
    }

}
