public class Shield extends  Weapon{
    public Shield(String name, int weight, int value) {
        super(name, weight, value);
    }

    @Override
    public void attack(Character attacker, Character defender){
        int damage = attacker.getVitality()*attacker.getWeaponType().getValue();
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
    public void specialAbility(SpecialCharacter specialCharacter){
        int stunNumber=0;
        if(specialCharacter.getVitality()*specialCharacter
                .getWeaponType().getValue()>30){
            stunNumber=2;
            for(EnemyCharacter e : Main.enemyCharacterList){
                if(stunNumber>0){
                    if(!e.isStunned()){
                        e.setStunned(true);
                        System.out.println("Random two enemy stunned.");
                        stunNumber--;
                    }
                }
            }
        }else{
            stunNumber = 1;
            for(EnemyCharacter e : Main.enemyCharacterList){
                if(stunNumber>0){
                    if(!e.isStunned()){
                        System.out.println("Random one enemy stunned.");
                        e.setStunned(true);
                        stunNumber--;
                    }
                }
            }
        }
    }

    @Override
    public void specialAbility(SpecialCharacter healer, SpecialCharacter healed) {

    }


}
