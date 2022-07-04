public class EnemyCharacter extends Character implements EnemyCharacterInterface {
    private Weapon dropWeapon;

    public EnemyCharacter(Weapon dropWeapon){
        super("Enemy"+(Main.enemyCharacterList.size()+1));
        Main.enemyCharacterList.add(this);
        int tempNumber = super.randomNumber(1,10);
        this.setStrength(super.randomNumber(1,5));
        this.setVitality(super.randomNumber(1,5));
        this.setIntelligence(super.randomNumber(1,5));
        this.setMaxHP((int) (Math.round((0.7 * this.getVitality() + 0.2 * this.getStrength() + 0.1 * this.getIntelligence()))));
        this.setHp(this.getMaxHP());
        if(tempNumber<=8){
            this.setWeaponType(new Sword("Basic Sword",10,1));
        }else if(tempNumber==9){
            this.setWeaponType(new Shield("Basic Shield",10,1));
        }else if(tempNumber==10){
            this.setWeaponType(new Wand("Basic Wand",10,1));
        }
        this.dropWeapon= dropWeapon;
    }

    public static void target(Fighter fighter, Healer healer , Tank tank,EnemyCharacter enemyCharacter){
        if(!enemyCharacter.isStunned()){
            System.out.println("Enemy is attacking..");
            if(tank.getHp()>0){
                enemyCharacter.attack(tank,enemyCharacter);
            }else if(fighter.getHp()>0){
                enemyCharacter.attack(fighter,enemyCharacter);
            }else{
                enemyCharacter.attack(healer,enemyCharacter);
            }
        }else{
            System.out.println("Enemy is stunned, they can't attack right now.");
            enemyCharacter.setStunned(false);
        }

    }

    @Override
    public void attack(SpecialCharacter c1,EnemyCharacter enemyCharacter) {
        if(!c1.isSwordsSpecialAbilityUsed()) {
            enemyCharacter.getWeaponType().attack(enemyCharacter, c1);
        }else {
            System.out.println("Enemy tried to attack " + c1.getName() + " but character used Sword's special power.");
            for(SpecialCharacter character : Main.specialCharacterList){
                character.setSwordsSpecialAbilityUsed(false);
            }
        }
    }



    @Override
    public void death(Character ch) {
        System.out.println(this.getName()+" is dead and dropped "+this.getDropWeapon().getName()+".");
        Main.enemyCharacterList.remove(this);
        Main.itemDropList.add(this.getDropWeapon());
    }



    public Weapon getDropWeapon() {
        return dropWeapon;
    }

    public void setDropWeapon(Weapon dropWeapon) {
        this.dropWeapon = dropWeapon;
    }

}
