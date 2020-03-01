package family;

public class FamilyOverflowException extends RuntimeException {
    int countMembersFamily;

    public FamilyOverflowException(String message, int countMembersFamily) {
        super(message);
        this.countMembersFamily = countMembersFamily;
    }

    public int getCountMembersFamily() {
        return countMembersFamily;
    }
}
