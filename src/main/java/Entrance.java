import java.util.Queue;

public class Entrance implements Runnable {
    public int entranceID;
    public Queue<Group> groups;
    public SportsHall hall;

    public Entrance(int entranceID, Queue<Group> groups, SportsHall hall) {
        this.entranceID = entranceID;
        this.groups = groups;
        this.hall = hall;
    }

    @Override
    public void run() {
        for (Group g : groups) {
            boolean success = hall.seatGroup(g);

            if (success) {
                System.out.println("Successful seating at entrance " + entranceID + ": group with an ID " + g.getGroupID() + ",consisting of "
                        + g.getGroupSize() + " people, category seats: " + g.getSeatCategory());
            } else {
                System.out.println("Unsuccessful seating at entrance " + entranceID + ": group with an ID " + g.getGroupID() + ",consisting of "
                        + g.getGroupSize() + " people, category seats: " + g.getSeatCategory());
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
