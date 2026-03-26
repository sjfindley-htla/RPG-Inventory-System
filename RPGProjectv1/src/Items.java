public abstract class Items {
    public String name="";
    public String desc="";
    public double weight=0d;
    public boolean usable=false;
    public String itemType="";

    public Items(){

    }

    public void useItem() {
        if (!usable) {
            return;
        } else {
            if (itemType.equals("Weapon")) {
                System.out.println(Weapons.damageMessage);
            } else if (itemType.equals("Consumable")) {
                System.out.println(Consumables.useMessage);
                Consumables.used=true;
            }
        }
    }


    public static class Weapons extends Items {
        public static int damage=0;
        public static String damageMessage="You hit for "+damage+" damage";

        public Weapons() {
            this.usable=true;
            this.itemType="Weapon";
        }


        public static class Sword extends Weapons {
            public Sword() {
                this.name="Sword";
                this.desc="Long iron blade attached to a wooden hilt";
                this.weight=1.4d;
                damage=4;
            }
        }

    }

    public static class Consumables extends Items {
        public static String useMessage="";
        public static boolean used=false;

        public Consumables() {
            this.usable=true;
            this.itemType="Consumable";
        }

        public static class HealthPotion extends Consumables {
            public int heal=3;

            public HealthPotion() {
                this.name="Health Potion";
                this.desc="Heals for +"+heal+" hp";
                this.weight=0.2d;
                this.useMessage="You were healed for +"+heal+" hp";
            }
        }
    }

    public class Projectile extends Items {

    }

    public class QuestItem extends Items {

    }
}
