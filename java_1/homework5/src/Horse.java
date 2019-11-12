public class Horse extends Animals {
    static int rangeRun=1500;
    static int rangeSwim=100;
    static double rangeJump=3.0;
    public Horse(String name){
        super(name,rangeRun,rangeSwim,rangeJump);
        System.out.printf(text,name,getRangeRun(),getRangeSwim(),getRangeJump());
    }
    private String text="Лошадка %s может пробежать- %d метров, проплыть-%d метров, прерпрыгнуть через-%.1f метров(-а) \n";
}
