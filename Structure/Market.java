public class Market extends Structures {
    private int unitSpace;
    private static int buildCost = 5;

    public Market() {
        super(50, 5, 1, 3);
        this.unitSpace = 5;
    }

    @Override
    public void upgrade() {
        if (level < maxlevel) {
            level++;
            unitSpace += 5;
            helth += 20;
        }
    }

    public static int getNextBuildCost() {
        return buildCost;
    }

    public static void increaseBuildCost() {
        buildCost += 5;
    }
}
