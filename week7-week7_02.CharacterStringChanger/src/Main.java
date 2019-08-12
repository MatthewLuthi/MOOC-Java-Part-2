public class Main {
    public static void main(String[] args) {
        Changer changer = new Changer();
        
        changer.addChange(new Change('A', 'L'));
        changer.addChange(new Change('!', '?'));
        String word = changer.change("Architect!");
        System.out.println(word);
    }
}
