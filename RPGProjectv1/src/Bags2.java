import java.util.HashMap;
import java.util.Collection;
import java.util.Map;

public abstract class Bags2{
    public double maxWeight = 15d;
    public boolean full=false;

    HashMap<Integer, Items> storage = new HashMap<>();

    public Bags2() {

    }
    public void addItem(Items name, int slot) {
        bagFull();
        if (!full) {
            storage.putIfAbsent(slot, name);
        } else if (full) {
            System.out.println("Bag is full! "+name+" was not added to bag");
        }
    }

    public void useItem(Items name, int slot) {
        if (!name.usable) {
            return;
        } else {
            if (name.itemType.equals("Weapon")) {
                System.out.println(Items.Weapons.damageMessage);
            } else if (name.itemType.equals("Consumable")) {
                System.out.println(Items.Consumables.useMessage);
                Items.Consumables.used=true;
            }
            removeItem(name,slot);
        }
    }

    public void removeItem(Items name, int slot) {
        storage.remove(slot,name);
    }

    public double checkWeight(){
        double currentWeight=0d;
        for (int i=1;i<=storage.size();i++) {
            currentWeight=currentWeight+storage.get(i).weight;
        }
        return currentWeight;
    }


    public String showNames(int breakNum) {
        String currentName="";
        int timesRun=0;
        for (Map.Entry<Integer, Items> listNames : storage.entrySet()) {
            currentName=listNames.getValue().name;
            if (timesRun>=breakNum) {
                return currentName;
            }
            timesRun++;
        }
        return currentName;
    }
    public void bagFull() {
        if (checkWeight()>=maxWeight) {
            full=true;
        }
    }






    public static class SmallBag extends Bags2 {
        public SmallBag() {
            this.maxWeight=5d;
        }
    }
    public static class MediumBag extends Bags2 {
        public MediumBag() {
            this.maxWeight=10d;
        }
    }
    public static class LargeBag extends Bags2 {
        public LargeBag() {

        }
    }
}