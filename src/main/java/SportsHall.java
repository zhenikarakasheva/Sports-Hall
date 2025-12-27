import java.util.EnumMap;
import java.util.Map;

public class SportsHall {
    private final Map<SeatCategory, Integer> maxCapacity;
    private final Map<SeatCategory, Integer> availableSeats;

    public SportsHall(int courtSide, int lowerLevel, int upperLevel, int premium) {
        maxCapacity = new EnumMap<>(SeatCategory.class);
        availableSeats = new EnumMap<>(SeatCategory.class);

        maxCapacity.put(SeatCategory.COURTSIDE, courtSide);
        maxCapacity.put(SeatCategory.LOWERLEVEL, lowerLevel);
        maxCapacity.put(SeatCategory.UPPERLEVEL, upperLevel);
        maxCapacity.put(SeatCategory.PREMIUM, premium);

        availableSeats.putAll(maxCapacity);
    }

    public synchronized boolean seatGroup(Group group) {
        if (group.isHasBeenProcessed()) {
            System.out.println("Group " + group.getGroupID() + " has already been seated");
            return false;
        }
        int available = availableSeats.get(group.getSeatCategory());
        if (available >= group.getGroupSize()) {
            availableSeats.put(group.getSeatCategory(),available-group.getGroupSize());
            group.markProcessed();
            return true;
        }
        return false;
    }

    public void printSportsHall() {
        System.out.println("Sports Hall Seating");
        for (SeatCategory category : SeatCategory.values()) {
            int max = maxCapacity.get(category);
            int available = availableSeats.get(category);
            int occupied = max - available;

            System.out.println(category + ": occupied " + occupied + ", available " + available + ", max " + max);
        }
    }

    public int getAvailableSeats(SeatCategory seatCategory) {
        return availableSeats.get(seatCategory);
    }
}
