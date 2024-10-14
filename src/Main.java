import java.util.*; //user input class
public class Main {
    public static void main(String[] args) {
        new GameFrame();
        Scanner input = new Scanner(System.in);
        Random number = new Random();
        int[] dice = new int[3];
        int chipCount = 3;
        //the player approaches a table and is greeted by a well-dressed man
        System.out.println("Hello fellow gambler!");
        System.out.println("Would you be interested in a little game of dice?");
        String decision1 = input.nextLine();
        System.out.println("Fantastic! Let's begin shall we...");
        System.out.println("The game is very simple, you will be given three dice and 3 chips.\n" +
                "To begin a game, you will roll the dice!\nIf you roll a pair, you will receive a chip.\n" +
                "However, if a pair is not rolled then the player will lose a chip.\n" +
                "Do you understand the rules?");
        //Could possibly change this to adding the dice up results
        // and then bet higher or lower on the total number you receive.
        //if bet right, you get a chip. get it wrong, lose a chip.
        String decision2 = input.nextLine();
        while(chipCount > 0) {

            System.out.println("Roll.");
            String roll = input.next();

            //for loop generates rolled numbers
            for (int i = 0; i < dice.length; i++) {
                dice[i] = number.nextInt(6) + 1;
            }

            //print rolled numbers
            for (int i : dice) {
                System.out.print(i + " ");
            }

            //compare rolled numbers
            int pair = 0;
            if ((dice[0] == dice[1]) && (dice[0] == dice[2])) {
                chipCount = chipCount + 2;
                System.out.println("\nTriple " + dice[0] + "'s");
            }
            else if ( (dice[0] == dice[1]) || (dice[0] == dice[2]) ) {
                System.out.println("\npair of " + dice[0] + "'s");
                chipCount++;
            }
            else if(dice[1] == dice[2]){
                System.out.println("\npair of " + dice[1] + "'s");
                chipCount++;
            }
            else{
                System.out.println("\nNo pairs, roll again...");
                chipCount = chipCount - 1;
            }
            System.out.println("Chips:" + chipCount);
            if(chipCount == 10){
                System.out.println("Luck is definitley on your side! Leave...");
                break;
            }
        }
        if(chipCount == 0) {
            System.out.println("Looks like you are all out of chips... Better luck next time! \nhahaha loser");
        }
    }

}