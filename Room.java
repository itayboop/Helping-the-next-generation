public class Room {
    private int windows;
    private int beds;

    public Room(int beds, int windows) {
        this.beds = beds;
        this.windows = windows;
    }

    public int getBeds() {
        return this.beds;
    }

    public int getWindows() {
        return this.windows;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public void setWindows(int windows) {
        this.windows = windows;
    }
}