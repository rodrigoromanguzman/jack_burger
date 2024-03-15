public class MealOrder {
    private Burger burger;
    private Item drink;
    private Item side;
    public MealOrder(){
        this("regular","coke","fires");
    }

    public MealOrder(String burgerName, String drinkType, String sideType) {
        if(burgerName.equals("deluxe")){
            this.burger = new DeluxeBurger(burgerName,8.5);
        }else{
            this.burger = new Burger(burgerName,4.0);
        }
        this.burger = burger;
        this.drink = new Item("drink",drinkType,1.0);
        this.side = new Item("side",sideType,1.5);
    }

    public double getTotalPrice(){
        if(burger instanceof DeluxeBurger){
            return burger.getAdjustedPrice();
        }
        return side.getAdjustedPrice()+drink.getAdjustedPrice()+burger.getAdjustedPrice();

    }

    public void printItemList(){
        burger.printItem();
        if(burger instanceof DeluxeBurger){
            Item.printItem(drink.getName(),0);
            Item.printItem(side.getName(),0);
        }else{
            drink.printItem();
            side.printItem();
        }
        System.out.println("-".repeat(30));
        Item.printItem("Total price: $",getTotalPrice());
    }

    public void addBurgerToppings(String extra1,String extra2,String extra3){
        burger.addToppings(extra1,extra2,extra3);
    }
    public void addBurgerToppings(String extra1,String extra2,String extra3,String extra4,String extra5){
        if(burger instanceof DeluxeBurger db){
            db.addToppings(extra1,extra2,extra3,extra4,extra5);
        }else{
            burger.addToppings(extra1,extra2,extra3);
        }
    }
    public void setDrinkSize(String size){
        drink.setSize(size);
    }
}
