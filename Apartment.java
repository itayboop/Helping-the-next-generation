public class Apartment {
    private String owner;
    private Room[] rooms;

    public Apartment(String owner) {
        this.owner = owner;
        this.rooms = new Room[12];
    }

    public void addRoom(Room room) {
        int i = 0;
        for(i = 0; i < this.rooms.length && this.rooms[i] != null; i++) {}

        if(i < this.rooms.length) {
            this.rooms[i] = room;
        }
    }

    public Room[] getRooms() {
        return this.rooms;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }
}
