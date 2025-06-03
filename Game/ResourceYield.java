package Game;
// برای مشخص کردن تایپ منابع استفاده میشه
public class ResourceYield {
    private final ResourceType type;
    private final int amount;

    public ResourceYield(ResourceType type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    public ResourceType getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        if (type == ResourceType.NONE || amount == 0) {
            return "No resources";
        }
        return type.name() + ": " + amount;
    }
}