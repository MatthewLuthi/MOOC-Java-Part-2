package farmsimulator;

import java.util.ArrayList;
import java.util.Collection;

public class Farm implements Alive {
    private String owner;
    private Barn barn;
    private Collection<Cow> cows;
    
    public Farm(String owner, Barn barn) {
        this.owner = owner;
        this.barn = barn;
        cows = new ArrayList<Cow>();
    }
    
    public void manageCows() {
        barn.takeCareOf(cows);
    }
    
    public void installMilkingRobot(MilkingRobot milkingRobot) {
        milkingRobot.setBulkTank(barn.getBulkTank());
    }
    
    @Override
    public void liveHour() {
       if (cows.isEmpty()) {
           return;
       }
       
       for (Cow cow : cows) {
           cow.liveHour();
       }
    }
    
    public void addCow(Cow cow) {
        cows.add(cow);
    }
    
    public String getOwner() {
        return owner;
    }
    
    @Override
    public String toString() {
        String farmDescription = "Farm owner: "+owner+"\nBarn bulk tank: "+barn.getBulkTank().toString()+"\n";
        
        if (cows.isEmpty()) {
            return farmDescription+"No cows.";
        }
        
        farmDescription += "Animals:\n";
        for (Cow cow : cows) {
            farmDescription += "        "+cow.toString()+"\n";
        }
        
        return farmDescription;
    }
}
