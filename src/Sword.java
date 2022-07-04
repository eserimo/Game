public class Sword extends Weapon{
    public Sword(String name, int weight, int value) {
        super(name, weight, value);
    }

    @Override
    public void attack(Character attacker, Character defender){
        int damage = attacker.getStrength()*attacker.getWeaponType().getValue();
        defender.setHp(defender.getHp()-damage);
        if(defender.getHp()<=0){
            defender.death(defender);
            System.out.println("-----------------------");
        }else{
            System.out.println(defender.getName()+"'s new HP: "+defender.getHp());
            System.out.println("-----------------------");
        }

    }

    @Override
    public void specialAbility(SpecialCharacter ch) {
        System.out.println("Enemies can't attack for 1 turn.");
        for(SpecialCharacter character : Main.specialCharacterList){
            ch.setSwordsSpecialAbilityUsed(true);
        }
    }

    @Override
    public void specialAbility(SpecialCharacter healer, SpecialCharacter healed) {

    }

}

