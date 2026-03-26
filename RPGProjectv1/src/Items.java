public abstract class Items {
    public String name="";
    public String desc="";
    public double weight=0d;
    public boolean usable=false;
    public int quantity=0;
    public String itemType="";

    public int damage=4;
    public String damageMessage="You hit for "+damage+" damage";
    public String useMessage="";


    public Items(){

    }

    public static String displayStats(Items name) {
        String stats="";
        switch(name.itemType) {
            case "Weapon":
                stats="NAME: "+name.name+"\n"+"ITEM TYPE: "+name.itemType+"\n"+"DESC: "+name.desc+"\n"+"WEIGHT: "+name.weight+"kg\n"+"POWER: "+name.damage+" damage\n";
                return stats;
            case "Consumable":
                stats="NAME: "+name.name+"\n"+"ITEM TYPE: "+name.itemType+"\n"+"DESC: "+name.desc+"\n"+"WEIGHT: "+name.weight+"kg\n"+"EFFECT: "+name.useMessage+"\n";
                return stats;
            case "Projectile":
                stats="NAME: "+name.name+"\n"+"ITEM TYPE: "+name.itemType+"\n"+"DESC: "+name.desc+"\n"+"WEIGHT (COMBINED): "+name.weight+"kg\n"+"QUANTITY: "+name.quantity+"\n";
                return stats;
            case "Quest Item":
                stats="NAME: "+name.name+"\n"+"ITEM TYPE: "+name.itemType+"\n"+"DESC: "+name.desc+"\n"+"WEIGHT: "+name.weight+"kg\n";
                return stats;
            default:
                stats="error - item does not exist, or no item type is applied to it";
                return stats;
        }
    }


    public static class Weapons extends Items {
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
    }

    public static class Consumables extends Items {
        public Consumables() {
            this.usable=true;
            this.itemType="Consumable";
            this.quantity=1;

            this.damageMessage="";
            this.damage=0;
        }

        public static class HealthPotion extends Consumables {
            public int heal=3;

            public HealthPotion() {
                this.name="Health Potion";
                this.desc="Heals for +"+heal+" hp";
                this.weight=0.2d;
                this.useMessage="You heal for +"+heal+" hp";
            }
        }
    }

    public static class Projectiles extends Items {
        public Projectiles() {
            this.usable=true;
            this.itemType="Projectile";
        }
        public Projectiles(int quantity) {
            this.usable=true;
            this.itemType="Projectile";
            this.quantity=quantity;
        }

        public static class Snowball extends Projectiles {
            public Snowball(int quantity) {
                this.name="Snowball";
                this.desc="Thrown for fun.";
                this.weight=0.02d*quantity;
                this.quantity=quantity;
            }
        }
    }

    public static class QuestItem extends Items {
        public QuestItem() {
            this.usable=false;
            this.itemType="Quest Item";
            this.quantity=1;
        }

        public static class Key extends QuestItem {
            public Key() {
                this.name="Key";
                this.desc="Opens a door... somewhere.";
                this.weight=0.3d;
            }
        }
    }
}
