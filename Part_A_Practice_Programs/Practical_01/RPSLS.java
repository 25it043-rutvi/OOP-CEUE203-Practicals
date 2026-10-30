import java.util.*;
public class RPSLS {
    enum Move { ROCK, PAPER, SCISSORS, LIZARD, SPOCK }
    static int winner(Move a, Move b) {
        if (a == b) return 0;
        return switch (a) {
            case SCISSORS -> (b == Move.PAPER || b == Move.LIZARD) ? 1 : -1;
            case PAPER -> (b == Move.ROCK || b == Move.SPOCK) ? 1 : -1;
            case ROCK -> (b == Move.LIZARD || b == Move.SCISSORS) ? 1 : -1;
            case LIZARD -> (b == Move.SPOCK || b == Move.PAPER) ? 1 : -1;
            case SPOCK -> (b == Move.SCISSORS || b == Move.ROCK) ? 1 : -1;
        };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); Random random = new Random();
        int player = 0, computer = 0;
        Move[] moves = Move.values();
        for (int i = 1; i <= 5; i++) {
            System.out.print("Round " + i + " - enter ROCK/PAPER/SCISSORS/LIZARD/SPOCK: ");
            Move p = Move.valueOf(sc.next().toUpperCase()), c = moves[random.nextInt(5)];
            int result = winner(p, c);
            System.out.println("You: " + p + ", Computer: " + c);
            if (result > 0) { player++; System.out.println("You win this round"); }
            else if (result < 0) { computer++; System.out.println("Computer wins this round"); }
            else System.out.println("Tie");
        }
        System.out.println("Final score: You " + player + " - " + computer + " Computer");
    }
}
