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
        switch(name.itemType) {
            case "Weapon":
                System.out.println(Items.Weapons.damageMessage);
                break;
            case "Consumable":
                System.out.println(Items.Consumables.useMessage);
                removeItem(name,slot);
                break;
            case "Projectile":
                if (name.quantity>0) {
                    name.quantity=name.quantity-1;
                    if (name.quantity==0) {
                        removeItem(name,slot);
                    }
                } else {
                    removeItem(name,slot);
                }
                break;
            default:
                System.out.println(name.name+" is not able to be used");
                return;
        }
    }

    public void removeItem(Items name, int slot) {
        storage.remove(slot,name);
    }

    public double checkWeight(){
        double currentWeight=0d;
        for (int i=1;i<=storage.size();i++) {
            if (storage.containsKey(i)) {
                currentWeight = currentWeight + storage.get(i).weight;
            } else if (storage.containsKey(i+1)) {
                currentWeight=currentWeight+storage.get(i+1).weight;
            } else {
                currentWeight=currentWeight;
            }
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