package hyperskill.enums;

public class DirectionTest {
    public static void main(String[] args) {
        String N = Direction.NORTH.getShortCode();
        System.out.println(N);

        String northName = Direction.NORTH.name();
        System.out.println(northName);

        String nToString = Direction.NORTH.toString();
        System.out.println(nToString);

        Direction valueOf = Direction.valueOf("NORTH");
        System.out.println(valueOf);

    }

    enum Direction {
        EAST("E"),
        WEST("W"),
        NORTH("N"),
        SOUTH("S");

        private final String shortCode;

        Direction(String code) {
            this.shortCode = code;
        }

        public String getShortCode() {
            return this.shortCode;
        }
    }
}
