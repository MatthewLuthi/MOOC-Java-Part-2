
import java.util.HashMap;
import java.util.Map;

public class Nicknames {

    public static void main(String[] args) {
        HashMap<String, String> people = new HashMap<String, String>();
        people.put("matti", "mage");
        people.put("mikael", "mixu");
        people.put("arto", "arppa");
        
        System.out.println(people.get("mikael"));
        
    }

}
