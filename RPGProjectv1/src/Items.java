public abstract class Items {
    public String name="";
    public String desc="";
    public double weight=0d;
    public boolean usable=false;
    public int quantity=0;
    public String itemType="";

    public Items(){

    }


    public static class Weapons extends Items {
        public static int damage=4;
        public static String damageMessage="You hit for "+damage+" damage";

        public Weapons() {
            this.quantity=1;
            this.usable=true;
            this.itemType="Weapon";
        }


        public static class Sword extends Weapons {
            public Sword() {
                this.name="Sword";
                this.desc="Used to deal melee damage.";
                this.weight=1.4d;
            }
        }

        public static class Bow extends Weapons {
            public Bow() {
                this.name="Bow";
                this.desc="Used to shoot arrows, dealing ranged damage.";
                this.weight=0.8d;
                damage=2;
            }
        }

    }

    public static class Consumables extends Items {
        public static String useMessage="";

        public Consumables() {
            this.usable=true;
            this.itemType="Consumable";
            this.quantity=1;
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

    public static class Projectiles extends Items {
        public Projectiles() {

        }
        public Projectiles(int quantity) {
            this.usable=true;
            this.itemType="Projectile";
            this.quantity=quantity;
        }

        public static class Arrow extends Projectiles {
            public Arrow() {
                this.name="Arrow";
                this.desc="Shot through bow.";
                this.weight=0.02d;
            }
        }
    }

    public class QuestItem extends Items {

    }
}
