public abstract class Weapon extends Item{
    public Weapon(String name, int weight, int value) {
        super(name, weight, value);
    }

    public abstract void attack(Character attacker, Character defender);


    public static Weapon randomWeapon(){
        int number =(int) Math.floor(Math.random()*(9)+1);
        switch(number){
            case 1:
                return new Sword("Basic Sword", 1, 10);
            case 2:
                return new Sword("Long Sword", 2, 20);
            case 3:
                return new Sword("Golden Sword", 3, 30);
            case 4:
                return new Sword("Basic Wand", 1, 10);
            case 5:
                return new Sword("Golden Wand", 3, 30);
            case 6:
                return new Sword("Magic Wand", 2, 20);
            case 7:
                return new Sword("Basic Shield", 1, 10);
            case 8:
                return new Sword("Heavy Shield", 2, 20);
            case 9:
                return new Sword("Golden Shield", 3, 30);

        }
        return null;
    }

    public abstract void specialAbility(SpecialCharacter ch);

    public abstract void specialAbility(SpecialCharacter healer, SpecialCharacter healed);
}

