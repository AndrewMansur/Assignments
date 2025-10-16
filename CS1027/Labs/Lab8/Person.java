public class Person implements Comparable<Person> {

    private String name;
    private String city;
    private String email;

    public Person(String name, String email, String city) {
        this.name = name;
        this.email = email;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    private int compareByName(Person other) {
        return -1 * this.name.compareTo(other.name);
    }

    private int compareByEmail(Person other) {
        return this.email.compareTo(other.email);
    }

    private int compareByCity(Person other) {
        return this.city.compareTo(other.city);
    }

    public int compareTo(Person other) {
        if (ContactList.sortBy == 'n') {
            return compareByName(other);
        } else if (ContactList.sortBy == 'e') {
            return compareByEmail(other);
        } else if (ContactList.sortBy == 'c') {
            return compareByCity(other);
        } else {
            return 0;
        }
    }

    public String toString() {
        String s = String.format("%-20s %-30s %-20s", name, email, city);
        return s;
    }
}
