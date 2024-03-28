public class ArrayEquals {
    //Used to test if the Blank and the WordArry are equal to see if the player has won
    public boolean arrayEquals (char[] WordArray, char[] Blank) {
        int j = 0;
        for(int i = 0; i < WordArray.length; i++) {
            if (WordArray[i] == Blank[i]) {
                j++;
            }
        }
        if (j < WordArray.length) {
            return true;
        } else {
            return false;
        }
    }//End ArrayEquals
}
