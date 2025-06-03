public class Tower extends Structures {
    private static int buildCost = 5;

    public Tower() {
        super(50, 5, 1, 3);
    }

    @Override
    public void upgrade() {
        if (level < maxlevel) {
            level++;
            helth += 20;
        }
    }

    public static int getBuildCost() {
        return buildCost;
    }

    public static void increaseBuildCost() {
        buildCost += 5;
    }
}
