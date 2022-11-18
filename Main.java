import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board theBoard = new Board();
        //System.out.println(theBoard.getCurrentPhrase());
        
        Scanner scan = new Scanner(System.in);
        String guessed;
        
        System.out.println("Player 1: What is your name?");
        Player player1 = new Player(scan.nextLine());
        System.out.println("Player 2: What is your name?");
        Player player2 = new Player(scan.nextLine());
        while (true) {
          theBoard.resetCurrentPhrase();
          theBoard.resetPhraseWithBlanks();
          System.out.println("\n" + theBoard.getPhraseWithBlanks());
          while (true) {
            System.out.println(player1.getName() + ": Guess a letter or phrase!");
            guessed = scan.nextLine();
            if (guessed.length() == 1) {
              theBoard.replace(guessed);
              System.out.println("\n" + theBoard.getPhraseWithBlanks());
              if (theBoard.getPhraseWithBlanks().equals(theBoard.getCurrentPhrase())) {
                player1.setScore(player1.getScore() + 1);
                System.out.println(player1.getName() + " wins!");
                break;
              }
            }
            else if (theBoard.getCurrentPhrase().equals(guessed)) {
              player1.setScore(player1.getScore() + 1);
              System.out.println(player1.getName() + " wins!");
              break;
            }
            else {
              System.out.println();
            }
            System.out.println(player2.getName() + ": Guess a letter or phrase!");
            guessed = scan.nextLine();
            if (guessed.length() == 1) {
              theBoard.replace(guessed);
              System.out.println("\n" + theBoard.getPhraseWithBlanks());
              if (theBoard.getPhraseWithBlanks().equals(theBoard.getCurrentPhrase())) {
                player2.setScore(player2.getScore() + 1);
                System.out.println(player2.getName() + " wins!\n");
                break;
              }
            }
            else if (theBoard.getCurrentPhrase().equals(guessed)) {
              player2.setScore(player2.getScore() + 1);
              System.out.println(player2.getName() + " wins!\n");
              break;
            }
            else {
              System.out.println();
            } 
          }
          System.out.println(player1.getName() + ":" + player1.getScore());
          System.out.println(player2.getName() + ":" + player2.getScore());
          System.out.println("Play again? (y/n)");
          if (!scan.nextLine().equals("y")) {
            System.out.println("\nThanks for playing!");
            break;
          }
        }
        scan.close();
    }
}
