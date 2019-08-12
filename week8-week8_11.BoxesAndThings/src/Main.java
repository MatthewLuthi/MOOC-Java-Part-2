public class Main {
    public static void main(String[] args) {
        Box box = new Box(20);
        Box smallBox = new Box(10);
        box.add(smallBox);
        smallBox.add(new Book("Horsemen", "Core Java", 5));
        box.weight();
        System.out.println(box.weight());
    }
}
