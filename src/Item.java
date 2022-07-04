public abstract class Item {
    private String name;
    private int Weight;
    private int value;

    public Item(String name, int weight, int value) {
        this.name = name;
        Weight = weight;
        this.value = value;
    }

    public void displayItem(){
        System.out.printf("Name: %s -- Value: %d -- Weight: %d%n",this.getName(),this.getValue(),this.getWeight());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

