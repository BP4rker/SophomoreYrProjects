import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.awt.event.KeyEvent;
        import java.awt.event.KeyListener;
        import java.util.LinkedList;
        import java.util.Random;
import java.util.Scanner;

/**
 * Current:
 * One snake and one food, No poison
 * The snake does not die when it bumps into itself
 * when the snake grows, it does not move faster
 */
public class Snake_Game extends JFrame {
    // A snake is just a list of coordinates (java.util.LinkedList, not our List)
    private LinkedList<Coordinate> snake = new LinkedList<Coordinate>();
    private int Score = 0;
    // The snake grows when it eats food
    private LinkedList<Coordinate> food = new LinkedList<Coordinate>();
    private LinkedList<Coordinate> poison = new LinkedList<Coordinate>();

    // The game is on or over
    private static enum Game {
        ON, OVER, WIN
    }

    ;
    private Game status = Game.ON;

    // Repeatedly moves the snake
    private Timer timer;

    // The snake can move in one of 4 directions
    public static enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    ;
    // The snake's current direction (heading). Default: moving right
    private Direction heading = Direction.RIGHT;

    // The snake can't switch to the opposite direction
    public boolean oppositeDirection(Direction newHeading) {
        return (heading == Direction.UP && newHeading == Direction.DOWN) ||
                (heading == Direction.DOWN && newHeading == Direction.UP) ||
                (heading == Direction.LEFT && newHeading == Direction.RIGHT) ||
                (heading == Direction.RIGHT && newHeading == Direction.LEFT);
    }

    // Update the heading based on the new heading
    public void changeHeading(Direction newHeading) {
        if (!oppositeDirection(newHeading)) {
            heading = newHeading;
        }
    }

    // Handle keyboard input (arrows change the snake's heading)
    private class KeyControl implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            Direction newHeading = heading;

            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_KP_LEFT:
                    newHeading = Direction.LEFT;
                    break;
                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_KP_RIGHT:
                    newHeading = Direction.RIGHT;
                    break;
                case KeyEvent.VK_UP:
                case KeyEvent.VK_KP_UP:
                    newHeading = Direction.UP;
                    break;
                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_KP_DOWN:
                    newHeading = Direction.DOWN;
                    break;
            }
            changeHeading(newHeading);
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }

    // An (x,y) coordinate in a 64 by 48 grid
    public static class Coordinate {
        public final int x;
        public final int y;

        // By default, construct a random coordinate not too far from the wall
        Coordinate() {
            this.x = new Random().nextInt(60) + 2;
            this.y = new Random().nextInt(40) + 2;
        }

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    @Override
    // This view renders the snake and food
    // Each snake coordinate is a 10x10 pixel square
    public void paint(Graphics g) {
        g.clearRect(0, 0, 640, 480);
        Color green = new Color(0, 128, 0);
        g.setColor(green);

        for (Coordinate c : snake) {
            g.fillRect(c.x * 10, c.y * 10, 10, 10);
        }
        g.setColor(Color.BLUE);
        for (Coordinate i : food) {
            g.fillOval(i.x * 10, i.y * 10, 10, 10);
        }
        g.setColor(Color.RED);
        for (Coordinate b : poison) {
            g.fillOval(b.x * 10, b.y * 10, 10, 10);
        }
    }

    // The snake's heading determines its new head coordinate
    private Coordinate newHead() {
        Coordinate head, newHead;
        head = snake.getFirst();

        switch (heading) {
            case DOWN:
                newHead = new Coordinate(head.x, head.y + 1);
                break;
            case LEFT:
                newHead = new Coordinate(head.x - 1, head.y);
                break;
            case RIGHT:
                newHead = new Coordinate(head.x + 1, head.y);
                break;
            case UP:
                newHead = new Coordinate(head.x, head.y - 1);
                break;
            // The default case is never reached because we have only 4 events.
            default:
                newHead = new Coordinate();
                break;
        }
        return newHead;
    }

    public void makeFood() {
        food.clear();
        for (int i = 0; i < 5; i++) {
            Coordinate food_new = new Coordinate();
            food.add(food_new);
        }
    }

    public void makePoison() {
        poison.clear();
        for (int i = 0; i < 5; i++) {
            Coordinate poison_new = new Coordinate();
            poison.add(poison_new);
        }
    }

    // When the snake moves, it can hit the wall, hit the food, poison (not implemented) or itself (not implemented)
    public void move() {
        Coordinate newHead = newHead();

        if(hitTheTail(newHead)){
            Score = 0;
            status = Game.OVER;
            return;
        }

        if (hitThePoison(newHead)) {
            Score = 0;
            status = Game.OVER;
            return;
        }


        if (hitTheWall(newHead)) {
            Score = 0;
            status = Game.OVER;
            return; // will return back to where this method is called
        }
        snake.addFirst(newHead);
        if(Score >= 20){
            status = Game.WIN;
        }
        else {
            timer.setDelay(150 - 4*Score);
            setTitle("Score = "+Integer.toString(Score));
            if (hitTheFood(newHead)) {
                Score++;
                for (int i = 0; i <= food.size(); i++) {
                    food.clear();
                    makeFood();
                }
                for (int i = 0; i <= food.size(); i++) {
                    makePoison();
                }
            } else {
                snake.removeLast();
            }
        }
    }

    private boolean hitTheFood(Coordinate newHead) {
        for (Coordinate i : food) {
            if (newHead.x == i.x && newHead.y == i.y) {
                return true;
            }
        }
        return false;
    }

    private boolean hitThePoison(Coordinate newHead){
        for(Coordinate i: poison) {
            if (newHead.x == i.x && newHead.y == i.y) {
                return true;
            }
        }
        return false;
    }

    // Checks to see if the head and the tail collide
    private boolean hitTheTail(Coordinate newHead){
        for(Coordinate i:snake){
            if (newHead.x == i.x && newHead.y == i.y) {
                return true;
                }
            }
        return false;
    }
    public boolean hitTheWall(Coordinate head) {
        return (head.x == 64 || head.y == 48 || head.x == 0 || head.y == 0);
    }

    // The timer moves the snake using this class.
    private class SnakeMover implements ActionListener {
        @Override
        // Listening Action (in this case Timer - every certain millisecond) and execute this method
        public void actionPerformed(ActionEvent e) {
            move();
            repaint();    // from AWT library. It will call paint() automatically
            if (status == Game.OVER) {
                playAgain("The snake's dead");
            }
            if(status == Game.WIN){
                playAgain("You Win! Would You Like To Play Again?");
            }
        }
    }

    // Ask the player what to do when the game is over
    private void playAgain(String message) {
        String[] options = new String[]{"Play again", "Quit"};
        int choice = JOptionPane.showOptionDialog(null, message, "Game over", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            initialize();
        } else {
            System.exit(0);
        }
    }

    // Initialize game (snake, food, etc)
    private void initialize() {
        status = Game.ON;

        // Make a small snake with 1 node (a 10x10 pixel coordinate)
        snake.clear(); // remove all of the elements of the LinkedList
        snake.add(new Coordinate()); // append the new element to the end of the LinkedList
        food.add(new Coordinate());
        makeFood();
        makePoison();

    }

    public Snake_Game() {

        setSize(640, 480);    // Window size - pixel
        setVisible(true);

        // Update the snake's direction using keyboard arrows
        // Event Handler: addKeyListener is from AWT library. This is how to "register" event
        addKeyListener(new KeyControl());

        // Make the snake move every 150 milliseconds
        timer = new Timer(150, new SnakeMover());
        timer.start();

        // Initialize game (snake, food)
        initialize();

    }

    public static void main(String[] args) {
        new Snake_Game();
    }
}

