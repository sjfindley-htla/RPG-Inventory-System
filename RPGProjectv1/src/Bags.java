import java.util.HashMap;
import java.util.Collection;
import java.util.Map;

public abstract class Bags{
    public double maxWeight = 15d;
    public int maxRoom = 10;
    public int maxCapacity=15;
    public boolean full=false;

    HashMap<String, Double> storageW = new HashMap<>();
    HashMap<String, Integer> storageS = new HashMap<>();
    HashMap<Integer, String> storageSlots = new HashMap<>();

    public Bags() {

    }
    public void addItem(String name, double weight, int space, int slot) {
        bagFull();
        if (!full) {
            storageW.putIfAbsent(name, weight);
            storageS.putIfAbsent(name, space);
            storageSlots.putIfAbsent(slot, name);
        } else if (full) {
            System.out.println("Bag is full! "+name+" was not added to bag");
        }
    }

    public void removeItem(String name) {
        storageW.remove(name);
        storageS.remove(name);
    }

    public double checkWeight(String name){
        return storageW.get(name);
    }

    public int checkSpace(String name) {
        return storageS.get(name);
    }

    public int checkSlots() {
        return maxCapacity-storageSlots.size();
    }

    public double calculateWeight() {
        double currentW=0d;

        for (Map.Entry<String, Double> weightCalc : storageW.entrySet()) {
            currentW=currentW+weightCalc.getValue();
        }
        return currentW;
    }

    public String showNames(int breakNum) {
        String currentName="";
        int timesRun=0;
        for (Map.Entry<Integer, String> listNames : storageSlots.entrySet()) {
            currentName=listNames.getValue();
            if (timesRun>=breakNum) {
                return currentName;
            }
            timesRun++;
        }
        return currentName;
    }
    public void bagFull() {
        if (checkSlots()==0) {
            full=true;
        }
        if (calculateWeight()>=maxWeight) {
            full=true;
        }
    }






    public static class SmallBag extends Bags {
        public SmallBag() {
            this.maxWeight=5d;
            this.maxRoom=4;
            this.maxCapacity=6;
        }
    }
    public static class MediumBag extends Bags {
        public MediumBag() {
            this.maxWeight=10d;
            this.maxRoom=6;
            this.maxCapacity=10;
        }
    }
    public static class LargeBag extends Bags {
        public LargeBag() {

        }
    }
}