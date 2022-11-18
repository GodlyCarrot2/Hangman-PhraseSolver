import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class Board {
  private String currentPhrase;
  private String phraseWithBlanks;
  private ArrayList<String> lettersGuessed = new ArrayList<String>();

  private static String loadPhrase() {
      String tempPhrase = "";
      
      int numOfLines = 0;
      tempPhrase = "how are you";
      
      try 
      {
        
        Scanner sc = new Scanner(new File(/*Replace with the path*/"/workspace/Hangman-PhraseSolver/phrases.txt"));
        while (sc.hasNextLine())
        {
          tempPhrase = sc.nextLine().trim();
          numOfLines++;
        }
      } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
      
      int randomInt = (int) ((Math.random() * numOfLines) + 1);
      
      try 
      {
        int count = 0;
        Scanner sc = new Scanner(new File("/workspace/Hangman-PhraseSolver/phrases.txt"));
        while (sc.hasNextLine())
        {
          count++;
          String temp = sc.nextLine().trim();
          if (count == randomInt)
          {
            tempPhrase = temp;
          }
        }
      } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    return tempPhrase;
  }

  public Board() {
    this.currentPhrase = loadPhrase();
    this.phraseWithBlanks = this.currentPhrase.replaceAll("[a-z]", "?");
  }
  
  public String getCurrentPhrase() {
    return this.currentPhrase;
  }
  
  public String getPhraseWithBlanks() {
    return this.phraseWithBlanks;
  }

  public void resetCurrentPhrase() {
    this.currentPhrase = loadPhrase();
  }

  public void resetPhraseWithBlanks() {
    this.phraseWithBlanks = this.currentPhrase.replaceAll("[a-z]", "?");
  }

  public void replace(String letter) {
    for (int i = 0; i < this.currentPhrase.length(); i++) {
      if (this.currentPhrase.substring(i,i+1).equals(letter)) {
        this.phraseWithBlanks = this.phraseWithBlanks.substring(0,i) + letter + this.phraseWithBlanks.substring(i+1);
      }
    }
  }
}