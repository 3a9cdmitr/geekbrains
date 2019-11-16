public class Cat extends Animals {
    static int rangeRun=200;
    static double rangeJump=2;

    protected Cat(String Name) {
        super(Name, rangeRun,rangeJump);
        System.out.printf(text,name,getRangeRun(),getRangeJump());
    }
    private String text="Котик %s может пробежать- %d метров, прерпрыгнуть через-%.1f метров(-а) \n";

    @Override
    protected void swim(int distance) {
        System.out.println(" "+this.name+ " не умеет плавать!(не топите котиков)");
    }
}
