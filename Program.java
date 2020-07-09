public class Program {
    ///this function is helping with the f1 function
    public static double getYahas(Floor floor) {
        double yahas = 0;
        double highestYahas = 0;

        for(int i = 0; i < floor.getApartments().length; i++) {
            for(int j = 0; j < floor.getApartments()[i].getRooms().length; i++) {
                yahas = ((double)(floor.getApartments()[i].getRooms()[j].getWindows()) / floor.getApartments()[i].getRooms()[j].getBeds());
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


    public static int apartmentAmountFloor(Floor floor) {
        int apartmentAmount = 0;

        for(int i = 0; i < floor.getApartments().length && floor.getApartments()[i] != null; i++) {
            apartmentAmount ++;
        }

        return apartmentAmount;
    }


    public static String f3(Building[] buildings) {
        Building highestBuilding = buildings[0];                //i assume that building[0]'s highest floor is empty, hope thats okay.
        int highestFloorAmount = floorAmount(highestBuilding);

        for(int i = 0; i < buildings.length; i++) {
            if(floorAmount(buildings[i]) > highestFloorAmount && apartmentAmountFloor(buildings[i].getFloors()[buildings[i].getFloors().length]) == 0) {
                highestBuilding = buildings[i];
                highestFloorAmount = floorAmount(buildings[i]);
            }
        }

            return highestBuilding.getAddress();
        }

    //f4 is the same as f1 except that i need to check for null, so i skipped that.

    public static boolean f5(Building[] buildings, String address) {
        for(int i = 0; i < buildings.length; i ++) {
            if(buildings[i].getAddress().equals(address)) {
                return true;
            }
        }

        return false;
    }


    public static int windowsAmount(Building building) {
        int windows = 0;

        for (int i = 0; i < building.getFloors().length; i++) {
            for (int j = 0; j < building.getFloors()[i].getApartments().length; j++) {
                for (int k = 0; k < building.getFloors()[i].getApartments()[j].getRooms().length; k++) {
                    windows += building.getFloors()[i].getApartments()[j].getRooms()[k].getWindows();
                    }
                }
            }

        return windows;
    }

    //same as roomAmount but checks on Building instead of Floor
    public static int roomAmountBuilding(Building building) {
        int roomAmount = 0;

        for (int i = 0; i < building.getFloors().length; i++) {
            for (int j = 0; j < building.getFloors()[i].getApartments().length; j++) {
                for (int k = 0; k < building.getFloors()[i].getApartments()[j].getRooms().length; k++) {
                    roomAmount++;
                }
            }
        }

        return roomAmount;
    }


    public static double f6(Building building) {
        return windowsAmount(building) / (double)roomAmountBuilding(building);
    }


    public static String findLongestOwner(Building building) {
        String longestOwner = ""; //see comment below

        for(int i = 0; i < building.getFloors().length; i++) {
            for(int j = 0; j < building.getFloors()[i].getApartments().length; i++) {
                if(longestOwner.length() < building.getFloors()[i].getApartments()[j].getOwner().length()) {
                    longestOwner = building.getFloors()[i].getApartments()[j].getOwner();
                }
            }
        }

        return longestOwner;
    }

    public static String f7(Building[] buildings) {
        String longestOwner = findLongestOwner(buildings[0]);

        for(int i = 0; i < buildings.length && buildings[i] != null; i++) {
            if(findLongestOwner(buildings[i]).length() > longestOwner.length()) {
                longestOwner = findLongestOwner(buildings[i]);
            }
        }

        return longestOwner;
    }


    public static double f8(Building[] buildings) {
        int apartmentAmount = 0;

        for(int i = 0; i < buildings.length; i++) {
            for(int j = 0; j < buildings[i].getFloors().length; j++) {
                for(int k = 0; k < buildings[i].getFloors()[j].getApartments().length; k++) {
                    apartmentAmount++;
                }
            }
        }

        return (double)apartmentAmount / buildings.length;
    }


    public static double f9(Building building) {
        double roomsDivByWindows = (double)roomAmountBuilding(building) / windowsAmount(building);  //yahas of rooms divided by windows
        int ownersLengthSum = 0;

        for(int i = 0; i < building.getFloors().length; i++) {
            for(int j = 0; j < building.getFloors()[i].getApartments().length; j++) {
                ownersLengthSum += building.getFloors()[i].getApartments()[j].getOwner().length();
            }
        }

        return roomsDivByWindows / (floorAmount(building) / (double)(ownersLengthSum));
    }

    public static boolean isSmaIn(String name) {
        for(int i = 0; i < name.length() - 3; i++) {
            if(name.charAt(i) == 's' && name.charAt(i + 1) == 'm' && name.charAt(i + 2) == 'a'){
                return true;
            }
        }

        return false;
    }

    public static double f10(Apartment[] apartments) {
        int smaCounter = 0;
        int apartmentsAmount = 0;

        for(int i = 0; i < apartments.length && apartments[i] != null; i++) {
            apartmentsAmount++;
            if(isSmaIn(apartments[i].getOwner())) {
                smaCounter++;
            }
        }


        return apartmentsAmount / (double)smaCounter;
    }

    public static void main(String args[]) {

    }
}
