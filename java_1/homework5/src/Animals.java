public class Animals {
    protected String name;
    protected int rangeRun;
    protected int rangeSwim;
    protected double rangeJump;

    protected Animals(String Name, int rangeRun, int rangeSwim, double rangeJump) {
        this.name = Name;
        this.rangeRun = rangeRun;
        this.rangeSwim = rangeSwim;
        this.rangeJump = rangeJump;
    }
    protected Animals(String Name, int rangeRun, double rangeJump) {
        this.name = Name;
        this.rangeRun = rangeRun;
        this.rangeJump = rangeJump;
    }
    protected int getRangeRun() {return rangeRun;}
    protected int getRangeSwim() {return rangeSwim;}
    protected double getRangeJump() {return rangeJump;}
    protected void setRangeRun(int rangeRun) {this.rangeRun = rangeRun;}
    protected void setRangeSwim(int rangeSwim) {this.rangeSwim = rangeSwim;}
    protected void setRangeJump(double rangeJump) {this.rangeJump = rangeJump;}


    protected void run(int distance) {
        System.out.printf(" %s %s пробежал(а)!\n", this.name, ((distance <= this.rangeRun) ? "" : "НЕ"));

    }

    protected void swim(int distance) {
        System.out.printf(" %s %s пропрыл(а)!\n", this.name, ((distance <= this.rangeSwim) ? "" : "НЕ"));
    }

    protected void jump(double distance) {
        System.out.printf(" %s %s перепрыгнул(а)!\n", this.name, ((distance <= this.rangeJump) ? "" : "НЕ"));
    }
}
