public interface SpecialCharacterInterface {
    public void attack(SpecialCharacter character,EnemyCharacter defender);
    public void pick(SpecialCharacter ch,Item item);
    public void examine(SpecialCharacter ch, Item item);
    public void wield(SpecialCharacter ch, Weapon item);
    public void listInventory(SpecialCharacter ch);
}
