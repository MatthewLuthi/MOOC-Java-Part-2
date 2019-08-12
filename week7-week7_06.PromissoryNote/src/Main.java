public class Main {
    public static void main(String[] args) {
        PromissoryNote myNote = new PromissoryNote();
        
        myNote.setLoan("MII", 50.5);
        myNote.setLoan("Mack", 30.0);
        myNote.howMuchIsTheDebt("MII");
        System.out.println(myNote.howMuchIsTheDebt("MII"));
    }
}
