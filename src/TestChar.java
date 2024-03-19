public class TestChar {
    public int[] testChar(char[] WordArray, char ch) {
        int j = 0;
        int[] index = new int[(WordArray.length)];

        //Makes the index array have a value of -1 so when inputting the value of
        // the index where the character is.
        for(int m = 0; m< index.length; m++) {
            index[m] = -1;
        }//End For

        for(int i = 0; i < WordArray.length; i++) {
            if (Character.isUpperCase(ch)) {
                if ((int) ch == WordArray[i]) {
                    index[j] = i;
                    j++;
                } else if (((int)ch) + 32 == WordArray[i]) {
                    index[j] = i;
                    j++;
                }//End internal else if
            } else if (Character.isLowerCase(ch)) {
                if ((int) ch == WordArray[i]) {
                    index[j] = i;
                    j++;
                } else if (((int)ch) - 32 == WordArray[i]) {
                    index[j] = i;
                    j++;
                }//End internal else if
            }//End external else if
        }//End For
        return index;
    }//End testChar

    public boolean charCorrection (int[] index) {
        int j = 0;
        for(int i = 0; i < index.length; i++) {
            if (index[i] >= 0) {
                j++;
            }//End internal if
        }//End for
        if (j > 0) {
            return true;
        } else
            return false;
    }//End charCorrection
}
