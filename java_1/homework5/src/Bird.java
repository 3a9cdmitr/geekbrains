public class Bird extends Animals {
    static int rangeRun=500;
    static double rangeJump=0.5;

    protected Bird(String Name) {
        super(Name, rangeRun,rangeJump);
        System.out.printf(text,name,getRangeRun(),getRangeJump());
    }
    private String text="Птичка %s может пробежать- %d метров, прерпрыгнуть через-%.1f метров(-а) \n";

    @Override
    protected void swim(int distance) {
        System.out.println(" "+this.name+ " не умеет плавать!(не топите птичек)");
    }
}

