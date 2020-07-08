public class Building {
    private String address;
    private Floor[] floors;

    public Building(String address, int floorAmount) {
        this.address = address;
        this.floors = new Floor[floorAmount];
    }

    public boolean addFloor(Floor floor) {
        int i = 0;
        for(i = 0; i < this.floors.length&& this.floors[i] != null; i++){}

        if(i < this.floors.length) {
            this.floors[i] = floor;
        } else {
            return false;
        }

        return true;
    }

    public Floor[] getFloors() {
        return floors;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFloors(Floor[] floors) {
        this.floors = floors;
    }
}
