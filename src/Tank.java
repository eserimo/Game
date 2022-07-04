public class Tank extends SpecialCharacter{
    public Tank(Shield tankBasicShield){
        super();
        this.setName("Tank");
        this.setStrength(super.randomNumber(6,10));
        this.setVitality(super.randomNumber(3,7));
        this.setIntelligence(super.randomNumber(1,5));
        this.setMaxHP((int) (Math.round((0.7 * this.getVitality() + 0.2 * this.getStrength() + 0.1 * this.getIntelligence()))));
        this.setHp(this.getMaxHP());
        this.setWeaponType(tankBasicShield);
        this.getInventory().add(tankBasicShield);
    }


}
