package java1.lesson7;

public class Plate {
    private final int sizeOfPlate;
    private int foodInPlate;

    public Plate(int sizeOfPlate, int foodInPlate) {
        this.sizeOfPlate = sizeOfPlate;
        this.foodInPlate=foodInPlate;
    }

    public int getFood(int hungry){
        if(foodInPlate<hungry){
            System.out.println("В тарелке недостаточно еды");
            hungry-=foodInPlate;
            foodInPlate=0;
            return hungry;
        }
        else{
            foodInPlate-=hungry;
            System.out.println("В тарелке осталось еды:"+foodInPlate);
            return 0;
        }
    }

    public void addFood(int food){
        if ((food+foodInPlate)>sizeOfPlate){
            System.out.println("Тарелка заполнена доверху");
            foodInPlate=sizeOfPlate;
        }
        else {
            foodInPlate+=food;
            System.out.println("Сейчас еды в тарелке:"+foodInPlate);
        }
    }

    public int getFoodInPlate() {
        return foodInPlate;
    }
}
