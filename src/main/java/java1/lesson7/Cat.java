package java1.lesson7;

public class Cat {
    private final String name;
    private int hungry;
    private boolean satiety;

    public Cat(String name, int hungry) {
        this.name = name;
        this.hungry = hungry;
        this.satiety=false;
    }


    public boolean isSatiety() {
        return satiety;
    }

    public void eat(Plate plate){
        System.out.println("Котик "+name+" начал есть");
        hungry=plate.getFood(hungry);
        if(hungry==0) {
            satiety=true;
            System.out.println("Котик "+name+" сыт");
        }
        else System.out.println("Котик "+name+" не доел еды:"+hungry);
    }


}
