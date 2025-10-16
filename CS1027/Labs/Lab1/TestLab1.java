
public class TestLab1 {
    public static void main(String[] args) {
        Player p1 = new Player("Andrew", "defence", 99);

        System.out.println("Name: " + p1.getName());
        System.out.println("Position:" + p1.getPosition());
        System.out.println("Jersey Number:" +p1.getJerseyNum());

        p1.setJerseyNum(77);
        p1.setPosition("forward");

        System.out.println("\nName: " + p1.getName());
        System.out.println("Position:" + p1.getPosition());
        System.out.println("Jersey Number:" +p1.getJerseyNum());

        System.out.println(p1);

    }
}