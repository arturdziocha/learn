package hyperskill.enums;

/*
 * There is a robot in the game field. The position of the robot in this field is described by two integer coordinates: X and Y. The X axis is oriented from left to right, the Y axis — from bottom to top.

At the initial moment, the robot is in some coordinate on the field. It's also known where the robot looks: up, down, to the right or to the left. The initial position of the robot and its direction can have any values. You need to bring the robot to the destination point of the game field.

A robot is described by the Robot class. You can use the following methods of this class (with unknown implementation):

public class Robot {
 
    public Direction getDirection() {
        // current direction
    }
 
    public int getX() {
        // current X coordinate
    }
 
    public int getY() {
        // current Y o
    }
 
    public void turnLeft() {
        // rotate the robot 90 degrees counterclockwise
    }
 
    public void turnRight() {
        // rotate the robot 90 degrees clockwise
    }
 
    public void stepForward() {
        // take one step in the current direction
        // x or y coordinate will be changed by 1
    }
}
The direction of the robot is an enumeration:

public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}

Example

The following values are passed to the method: toX == 3, toY == 0. 
The initial state of this robot: robot.getX() == 0, robot.getY() == 0, robot.getDirection() == Direction.UP.
To bring the robot to the destination point (3, 0), the method should call the following methods:

robot.turnRight();
robot.stepForward();
robot.stepForward();
robot.stepForward();
Another Example

The following target values are passed to the method: toX == 0, toY == -1.
The initial state of this robot: robot.getX() == 1, robot.getY() == 1, robot.getDirection() == Direction.RIGHT.
To bring the robot to the destination point (0, -1), the method should call the following methods:

robot.turnRight();
robot.turnRight();
robot.stepForward();
robot.turnLeft();
robot.stepForward();
robot.stepForward();
Try to crack this problem!
 */
public class Robot {
    public static void main(String[] args) {
        Robot robot = new Robot(0, 0, Direction.DOWN);
        System.out.println(robot);
        moveRobot(robot, 10, 0);
        System.out.println(robot);
    }

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    private Direction direction;
    private int x;
    private int y;

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void turnLeft() {
        switch (direction) {
            case UP:
                this.direction = Direction.LEFT;
                break;
            case RIGHT:
                this.direction = Direction.UP;
                break;
            case DOWN:
                this.direction = Direction.RIGHT;
                break;
            case LEFT:
                this.direction = Direction.DOWN;
                break;
        }
    }

    public void turnRight() {
        switch (direction) {
            case UP:
                this.direction = Direction.RIGHT;
                break;
            case RIGHT:
                this.direction = Direction.DOWN;
                break;
            case DOWN:
                this.direction = Direction.LEFT;
                break;
            case LEFT:
                this.direction = Direction.UP;
                break;
        }
    }

    public void stepForward() {
        switch (direction) {
            case UP:
                y += 1;
                break;
            case LEFT:
                x -= 1;
                break;
            case DOWN:
                y -= 1;
                break;
            case RIGHT:
                x += 1;
                break;

        }
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        int moveX = Math.abs(toX - robot.getX());
        if (moveX != 0) {
            if (toX < robot.getX()) {
                while (robot.getDirection() != Direction.LEFT) {
                    robot.turnLeft();
                }
            } else {
                while (robot.getDirection() != Direction.RIGHT) {
                    robot.turnLeft();
                }
            }
            while (robot.getX() != toX) {
                robot.stepForward();
            }
        }
        int moveY = Math.abs(toY - robot.getY());
        if (moveY != 0) {
            if (toY < robot.getY()) {
                while (robot.getDirection() != Direction.DOWN) {
                    robot.turnRight();
                }
            } else {
                while (robot.getDirection() != Direction.UP) {
                    robot.turnRight();
                }
            }
            while (robot.getY() != toY) {
                robot.stepForward();
            }
        }
    }

    @Override
    public String toString() {
        return "Robot [direction=" + direction + ", x=" + x + ", y=" + y + "]";
    }

}

enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;
}