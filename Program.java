public class Program {
    ///this function is helping with the f1 function
    public static double getYahas(Floor floor) {
        double yahas = 0;
        double highestYahas = 0;

        for(int i = 0; i < floor.getApartments().length; i++) {
            for(int j = 0; j < floor.getApartments()[i].getRooms().length; i++) {
                yahas = (floor.getApartments()[i].getRooms()[j].getWindows() / floor.getApartments()[i].getRooms()[j].getBeds());
                if(yahas > highestYahas) {
                    highestYahas = yahas;
                }

            }
        }

        return highestYahas;
    }


    public static int f1(Building[] buildings) {
        Floor bestFloor = buildings[0].getFloors()[0];
        double bestYahas = getYahas(bestFloor);

        for(int i = 0; i < buildings.length; i++) {
            for(int j = 0; i < buildings[i].getFloors().length; i++) {
                if(getYahas(buildings[i].getFloors()[j]) > bestYahas) {
                    bestFloor = buildings[i].getFloors()[j];
                    bestYahas = getYahas(buildings[i].getFloors()[j]);
                }
            }
        }

        return bestFloor.getFloorNum();
    }

    public static int roomAmount(Floor floor) {
        int roomCount = 0;

        for(int i = 0; i < floor.getApartments().length && floor.getApartments()[i] != null; i++) {
            for(int j = 0; j < floor.getApartments()[i].getRooms().length && floor.getApartments()[i].getRooms()[j] != null; j++) {
                roomCount ++;
            }
        }

        return roomCount;
    }

    public static boolean f2(Floor[] floors) {
        Floor toCompare = floors[0];

        for(int i = 0; i < floors.length; i ++) {
            if(roomAmount(floors[i]) != roomAmount(toCompare)) {
                return false;
            }
        }

        return true;
    }

    public static int floorAmount(Building building) {
        int floorAmount = 0;

        for(int i = 0; i < building.getFloors().length && building.getFloors()[i] != null; i++) {
            floorAmount ++;
        }

        return floorAmount;
    }

    public static int apartmentAmount(Floor floor) {
        int apartmentAmount = 0;

        for(int i = 0; i < floor.getApartments().length && floor.getApartments()[i] != null; i++) {
            apartmentAmount ++;
        }

        return apartmentAmount;
    }

    public static String f3(Building[] buildings) {
        Building highestBuilding = buildings[0];
        int highestFloorAmount = floorAmount(highestBuilding);

        for(int i = 0; i < buildings.length; i++) {
            if(floorAmount(buildings[i]) > highestFloorAmount && apartmentAmount(buildings[i].getFloors()[buildings[i].getFloors().length]) == 0) {
                highestBuilding = buildings[i];
                highestFloorAmount = floorAmount(buildings[i]);
            }
        }

        return highestBuilding.getAddress();
    }

    public static void main(String args[]) {

    }
}
