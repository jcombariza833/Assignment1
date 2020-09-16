public class MenuItem {
    private String name;
    private int category;
    private boolean heartHealthy;
    private float price;

    public MenuItem(String name, int category, boolean heartHealthy, float price) {
        this.name = name;
        this.category = category;
        this.heartHealthy = heartHealthy;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getCategory() {
        return category;
    }

    public boolean isHeartHealthy() {
        return heartHealthy;
    }

    public float getPrice() {
        return price;
    }
}
