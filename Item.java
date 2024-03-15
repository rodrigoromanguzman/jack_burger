public class Item {
    private String type;
    private String name;
    private double price;
    private String size = "MEDIUM";
    public Item(String type,String name,double price){
        this.type = type.toUpperCase();
        this.name = name.toLowerCase();
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasePrice() {
        return price;
    }

    public double getAdjustedPrice(){
        return switch(size){
            case "SMALL" -> getBasePrice() - 0.5;
            case "MEDIUM" -> getBasePrice();
            case "LARGE" -> getBasePrice()+1;
            default -> getBasePrice();
        };
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    public static void printItem(String name, double price){
        System.out.printf("%20s:%6.2f %n",name,price);
    }
    public void printItem(){
        printItem(getName(),getAdjustedPrice());
    }
}
