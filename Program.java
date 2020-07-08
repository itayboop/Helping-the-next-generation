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

        for(int i = 0; i < floor.getApartments().length; i++) {
            for(int j = 0; j < floor.getApartments()[i].getRooms().length; j++) {
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


    public static void main(String args[]) {

    }
}
