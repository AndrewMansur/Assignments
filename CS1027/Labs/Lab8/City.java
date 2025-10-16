public class City implements Comparable<City> {

    private String name; 
    private int pop; 

    public City (String name, int pop) {
        this.name = name;
        this.pop = pop;
    }

    public String getName () {
        return name;
    }
    public int getPopulation () {
        return pop;
    }

    public String toString () {
        return name;
    }

    public int compareTo (City other) {
        if (this.pop < other.pop) {
            return -1;
        } else if (this.pop > other.pop) {
            return 1;
        } else { 
            return this.name.compareTo(other.name);
        }
    }

    public static void main(String[] args) {
        ArrayOrderedList<City> cities = new ArrayOrderedList<City>();
        cities.add(new City("Sao Paulo", 12000000));
        cities.add(new City("Mexico City", 9000000));
        cities.add(new City("Los Angeles", 4000000));
        cities.add(new City("Shanghai", 26000000));
        cities.add(new City("Madrid", 3000000));
        cities.add(new City("New York City", 9000000));
        cities.add(new City("Toronto", 3000000));

        System.out.println(cities);
    }

}
