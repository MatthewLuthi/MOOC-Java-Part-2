import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ShoppingBasket {
    private Map<String, Purchase> purchases;
    
    public ShoppingBasket() {
        purchases = new HashMap<String, Purchase>();
    }
    
    public Collection<Purchase> getValues() {
        return purchases.values();
    }
    
    public void add(String product, int price) {
        if (purchases.containsKey(product)) {
            purchases.get(product).increaseAmount();
        } else {
            purchases.put(product, new Purchase(product, 1, price));
        }
    }
    
    public int price() {
        int price = 0;
        
        for (Purchase purchase : getValues()) {
            price += purchase.price();
        }
        
        return price;
    }
    
    public void print() {
        for (Purchase purchase : getValues()) {
            System.out.println(purchase);
        }
    }
}
