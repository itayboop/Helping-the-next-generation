public class Floor {
    private int floorNum;
    private Apartment[] apartments;

    public Floor(int floorNum, int apartmentAmount) {
        this.floorNum = floorNum;
        this.apartments = new Apartment[apartmentAmount];
    }

    public void addApartment(Apartment apartment) {
        int i = 0;
        for(i = 0; i < this.apartments.length && this.apartments[i] != null; i++){}

        if(i < this.apartments.length) {
            this.apartments[i] = apartment;
        }
    }

    public Apartment[] getApartments() {
        return this.apartments;
    }

    public int getFloorNum() {
        return this.floorNum;
    }

    public void setFloorNum(int floorNum) {
        this.floorNum = floorNum;
    }

    public void setApartments(Apartment[] apartments) {
        this.apartments = apartments;
    }
}
