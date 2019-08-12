package farmsimulator;

import java.util.Collection;

public class Barn {
    private BulkTank tank;
    
    public Barn(BulkTank tank) {
        this.tank = tank;
    }
    
    public BulkTank getBulkTank() {
        return tank;
    }
    
    public void installMilkingRobot(MilkingRobot milkingRobot) {
        milkingRobot.setBulkTank(tank);
    }
    
    public void takeCareOf(Cow cow) {
        tank.addToTank(cow.milk());
    }
    
    public void takeCareOf(Collection<Cow> cows) {
        for (Cow cow : cows) {
            tank.addToTank(cow.milk());
        }
    }
    
    @Override
    public String toString() {
        return "Barn: "+Math.ceil(tank.getVolume())+"/"+tank.getCapacity();
    }
}
