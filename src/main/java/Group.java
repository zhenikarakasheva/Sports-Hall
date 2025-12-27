public class Group {
    private final int groupID;
    private final int groupSize;
    SeatCategory seatCategory;
    private boolean hasBeenProcessed = false;

    public Group(int groupID, int groupSize, SeatCategory seatCategory) {
        this.groupID = groupID;
        this.groupSize = groupSize;
        this.seatCategory = seatCategory;
    }

    public int getGroupID() {
        return groupID;
    }

    public int getGroupSize() {
        return groupSize;
    }

    public SeatCategory getSeatCategory() {
        return seatCategory;
    }

    public boolean isHasBeenProcessed() {
        return hasBeenProcessed;
    }

    public void markProcessed() {
        this.hasBeenProcessed = true;
    }
}
