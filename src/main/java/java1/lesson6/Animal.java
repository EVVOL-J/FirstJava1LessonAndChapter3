package java1.lesson6;

public class Animal {
    protected int maxRun;
    protected int maxSwim;
    protected int maxJump;
    protected String name;

    public Animal(int maxRun, int maxSwim, int maxJump, String name) {

        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
        this.maxJump = maxJump;
        this.name = name;
    }

    public boolean run(int length) {
        if (length <= this.maxRun) {
            System.out.println("Животное "+name+" пробежало дистнцию: " + length);
            return true;
        } else {
            System.out.println("Животное "+name+" потерпело неудачу при беге на дитанцию: " + length + " MAX: " + maxRun);
            return false;
        }
    }

    public boolean swim(int length) {
        if (length <= this.maxSwim){
            System.out.println("Животное "+name+" переплыло дистнцию:" + length);
            return true;
        }
        else{
            System.out.println("Животное "+name+" потерпело неудачу при плавании на дитанцию: " + length + " MAX: " + maxSwim);
            return false;
        }
    }

    public boolean jump(int length) {
        if (length <= this.maxJump){
            System.out.println("Животное "+name+" перепрыгнуло высоту: " + length);
            return true;
        }
        else{
            System.out.println("Животное  "+name+" потерпело неудачу при перепрыгивании высоты: " + length + " MAX: " + maxJump);
            return false;
        }

    }

    public void animalInfo() {
        System.out.println(toString());
        System.out.println("-------------");
    }

    @Override
    public String toString() {
        return "Animal{" +
                "maxRun=" + maxRun +
                ", maxSwim=" + maxSwim +
                ", maxJump=" + maxJump +
                ", name='" + name + '\'' +
                '}';
    }
}
