public class Dog extends Animals {
    static int rangeRun=500;
    static int rangeSwim=10;
    static double rangeJump=0.5;
    public Dog(String name){
        super(name,rangeRun,rangeSwim,rangeJump);
        System.out.printf(text,name,getRangeRun(),getRangeSwim(),getRangeJump());
    }
    private String text="Песик %s может пробежать- %d метров, проплыть-%d метров, прерпрыгнуть через-%.1f метров(-а) \n";

}
