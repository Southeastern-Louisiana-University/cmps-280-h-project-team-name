import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //Variables

        int testn = 0;

        //Class intialize
        Word w = new Word();
        arrToString as = new arrToString();
        TestChar tc = new TestChar();
        Stickman s = new Stickman();
        ArrayEquals ae = new ArrayEquals();

        //Creates Scanner
        Scanner input = new Scanner(System.in);


        System.out.println("Welcome to HangMan! Rules are simple: there will be a random word ");
        System.out.println("and you have to input a character to try to get the word. If you ");
        System.out.println("guess the wrong letter than a part of a Stickman will be drawn. If ");
        System.out.println("the Stickman is fully drawn you lose. If you get the word you win!");
        while(testn >= 0) {
            //Variables
            String word = "";
            int stage = 0;
            int randomN = 0; //RandomWords has 83367 lines, for future refrence.
            int l = 0;
            String category = "";
            int fail = 0;

            //Finds a word from a text file
            System.out.println("Choose categories, For test words inout 1, for randomwords input 2");
            String c = input.nextLine();
            if (c.equals("Test Word")) {
                randomN = (int)(Math.random() * 15) + 1;
                try (Stream<String> lines = Files.lines(Paths.get("src/Test Words"))) {
                    word = lines.skip((randomN - 1)).findFirst().get();
                    category = "(Remember, the word is a Test Word)";
                } catch (IOException e) {
                    System.out.println("Improper file directory");
                }//End Try/Catch
            } else if (c.equals("Random Word")) {
                randomN = (int)(Math.random() * 83367) + 1;
                try (Stream<String> lines = Files.lines(Paths.get("src/RandomWord"))) {
                    word = lines.skip((randomN - 1)).findFirst().get();
                    category = "(Remember, the word is random, sorry I can't help more)";
                } catch (IOException e) {
                    System.out.println("Improper file directory");
                }//End Try/Catch
            } else if (c.equals("Super Heroes")) {
                randomN = (int) (Math.random() * 83367) + 1;
                try (Stream<String> lines = Files.lines(Paths.get("src/Super Heroes"))) {
                    word = lines.skip((randomN - 1)).findFirst().get();
                    category = "(Remember, the word is a Super Hero)";
                } catch (IOException e) {
                    System.out.println("Improper file directory");
                }//End Try/Catch
            } else if (c.equals("Food")) {
                randomN = (int) (Math.random() * 83367) + 1;
                try (Stream<String> lines = Files.lines(Paths.get("src/Food"))) {
                    word = lines.skip((randomN - 1)).findFirst().get();
                    category = "(Remember, the word is a Food)";
                } catch (IOException e) {
                    System.out.println("Improper file directory");
                }//End Try/Catch
            } else {
                fail = 1;
                System.out.println("You have inputted the wrong word");
            }

            //Create arrays
            char[] WordArray = w.wordArr(word);
            char[] Blank = new char[WordArray.length];
            int[] index;
            char[] letters = new char[26];

            //Make the Blank array "_" for each character of the WordArray
            for(int i = 0; i < Blank.length; i++) {
                int valueOf = (WordArray[i]);
                if (valueOf == 32) {
                    Blank[i] = WordArray[i];
                } else {
                    Blank[i] = 95;
                }//End else
            }//End for loop

            //The actual game portion
            System.out.println(s.stickman(stage));

            boolean b = ae.arrayEquals(WordArray, Blank);

            while ((stage < 6) && b) {
                System.out.println(Blank);
                System.out.println(category);
                System.out.println("Input a character: ");
                char ch = input.next().charAt(0);
                if (tc.charCorrection(tc.testChar(letters, ch))) {
                    System.out.println("You have used this letter try again");
                } else {
                    letters[l] = ch;
                    l++;
                    index = tc.testChar(WordArray, ch);
                    if (tc.charCorrection(index)) {
                        for (int i = 0; i < index.length; i++) {
                            if (index[i] >= 0) {
                                int m = index[i];
                                Blank[m] = WordArray[m];
                            }//End internal if
                        }//End for
                    } else {
                        stage += 1;
                    }//End else
                    System.out.println(s.stickman(stage));

                    b = ae.arrayEquals(WordArray, Blank);
                }
            }//End internal while

                if (fail == 1) {

                } else if (stage >= 6) {
                    System.out.println("Sorry, you loss the word was " + word);
                } else if (!b) {
                    System.out.println("Congrats, you won!");
                }

            //Ask user to input value to see if they want to repeat
            System.out.print("\nDo you want to play again? Y/N: ");
            String check = input.next();

            //Separtes the first letter of the user's input
            String test = check.substring(0,1);

            //Defines s1 to be used to test the variables  test
            String s1 = "Y";

            //Fixes an error where when looped the message.nextLine would not prompt user for an input
            input.nextLine();

            //checks if test is true or false when compared to s1
            //if false it sets i = -1 so the loop will stop
            if ((!test.equalsIgnoreCase(s1))) {
                testn = -1;
            }//End if
        }//End while
    }//End main
}//End class
