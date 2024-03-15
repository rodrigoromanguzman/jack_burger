public class Burger extends Item{
    private Item item1;
    private Item item2;
    private Item item3;

    public Burger(String name,double price){
        super("Burger",name,price);
    }

    @Override
    public String getName(){
        return super.getName()+ " Burger";
    }
    @Override
    public double getAdjustedPrice(){
        return getBasePrice()+
                (((item1)== null)?0: item1.getAdjustedPrice())+
                (((item2)== null)?0: item2.getAdjustedPrice())+
                (((item3)== null)?0: item3.getAdjustedPrice());
    }
public double getExtraPrice(String toppingName){
        return switch (toppingName.toUpperCase()){
            case "LETTUCE" -> 0.3;
            case "AVOCADO","CHESSE" ->1.0;
            case "BACON","HAM","SALAMI"-> 1.5;
            default -> 0.0;
        };
}

public void addToppings(String item1, String item2, String item3){
        this.item1 = new Item("TOPPING",item1,getExtraPrice(item1));
    this.item2 = new Item("TOPPING",item2,getExtraPrice(item2));
    this.item3 = new Item("TOPPING",item3,getExtraPrice(item3));

}


    public Item getItem1() {
        return item1;
    }

    public void setItem1(Item item1) {
        this.item1 = item1;
    }

    public Item getItem2() {
        return item2;
    }

    public void setItem2(Item item2) {
        this.item2 = item2;
    }

    public Item getItem3() {
        return item3;
    }

    public void setItem3(Item item3) {
        this.item3 = item3;
    }

    public void printItemList(){
        printItem("BASE BURGER",getBasePrice());
        if(item1 != null){
            item1.printItem();
        }
        if(item2 != null){
            item2.printItem();
        }
        if(item3 != null){
            item3.printItem();
        }
    }
    @Override
    public void printItem(){
        printItemList();
        System.out.println("-".repeat(30));
        super.printItem();
    }


}
