import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Bags satchel = new Bags.SmallBag();
//        satchel.addItem("Sword",1.4d,2,1);
//        satchel.addItem("Shield",1.3d,2,2);
//        satchel.addItem("Health Pot",0.2d,1,3);
//        satchel.addItem("Rope",0.3d,1,4);
//        satchel.addItem("Axe",1.8d,3,5);
//        satchel.addItem("Boot",0.2d,1,6);
//        System.out.println("You currently have a "+satchel.storageW.keySet()+" that weighs "+satchel.storageW.get("Sword")+"kg, and takes up "+satchel.storageS.get("Sword")+" spaces in your bag");
//        System.out.println("You currently have a "+satchel.showNames(0)+" that weighs "+satchel.storageW.get(satchel.showNames(0))+"kg");
//        System.out.println(satchel.checkSpace("Sword"));
//        System.out.println(satchel.calculateWeight());

        //make bag exist
        Bags2 satchel = new Bags2.SmallBag();

        //make items exist
        Items sword = new Items.Weapons.Sword();
        Items healthPot = new Items.Consumables.HealthPotion();
        Items snowball = new Items.Projectiles.Snowball(4);


        //put items in bag
        satchel.addItem(sword, 1);
        satchel.addItem(healthPot,2);
        satchel.addItem(snowball,3);

        System.out.println(satchel.showNames(0));
        System.out.println(satchel.checkWeight());

        satchel.useItem(sword,1);
        satchel.useItem(healthPot,2);
        satchel.useItem(snowball,3);
        System.out.println(satchel.storage.values());
        System.out.println(snowball.quantity);
    }
}