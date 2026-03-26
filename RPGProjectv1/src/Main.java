public class Main {
    public static void main(String[] args) {
        //make bag exist
        Bags satchel = new Bags.SmallBag();

        //make items exist
        Items sword = new Items.Weapons.Sword();
        Items healthPot = new Items.Consumables.HealthPotion();
        Items snowball = new Items.Projectiles.Snowball(4);
        Items key = new Items.QuestItem.Key();


        //put items in bag
        satchel.addItem(sword, 1);
        satchel.addItem(healthPot,2);
        satchel.addItem(snowball,3);
        satchel.addItem(key,4);

        //tests weight calculation and displaying names of items
        System.out.println(satchel.showNames(0));
        System.out.println(satchel.checkWeight());

        //display stats
        System.out.println(Items.displayStats(sword));
        System.out.println(Items.displayStats(healthPot));
        System.out.println(Items.displayStats(snowball));
        System.out.println(Items.displayStats(key));



        //uses items
        satchel.useItem(sword,1);
        satchel.useItem(healthPot,2);
        satchel.useItem(snowball,3);
        satchel.useItem(key,4);

        //lists all current items + quantity of projectile
        System.out.println(satchel.storage.values());
        System.out.println(snowball.quantity);

        //uses projectile and checks to make sure weight decreases properly
        satchel.useItem(snowball,3);
        System.out.println(satchel.checkWeight());
        satchel.useItem(snowball,3);
        satchel.useItem(snowball,3);
        System.out.println(snowball.quantity);
        System.out.println(satchel.checkWeight());

        //lists all items currently in the bag again
        System.out.println(satchel.storage.values());
    }
}