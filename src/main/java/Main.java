import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        SportsHall hall = new SportsHall(200,100,120,50);
        hall.printSportsHall();

        Queue<Group> groups = new LinkedList<>();

        groups.add(new Group(1,50,SeatCategory.PREMIUM));
        groups.add(new Group(2,5,SeatCategory.COURTSIDE));
        groups.add(new Group(3,57,SeatCategory.LOWERLEVEL));
        groups.add(new Group(4,62,SeatCategory.UPPERLEVEL));
        groups.add(new Group(5,70,SeatCategory.COURTSIDE));
        groups.add(new Group(6,20,SeatCategory.COURTSIDE));
        groups.add(new Group(7,30,SeatCategory.UPPERLEVEL));
        groups.add(new Group(8,20,SeatCategory.COURTSIDE));
        groups.add(new Group(9,30,SeatCategory.UPPERLEVEL));
        groups.add(new Group(10,15,SeatCategory.COURTSIDE));

        Thread[] entrances = new Thread[4];

        for(int i = 0; i < 4; i++) {
            entrances[i] = new Thread(new Entrance(i+1,groups,hall));
            entrances[i].start();
        }

        for (Thread entrance: entrances) {
            try {
                entrance.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        hall.printSportsHall();
    }
}
