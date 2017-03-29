/**
 * Created by cxj on 17-3-29.
 */
public class Bitmap {
    public boolean isContinuous(int [] numbers) {
        if(numbers.length != 5) return false;
        byte[] istmp = new byte[2];
        int min = 14;
        int max = -1;
        for(int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if(number < 0 || number > 13) return false;
            if(number == 0) continue;

            if(((istmp[number / 8] >> number % 8) & 1) == 1) return false;
            istmp[number / 8] |= (1 << number % 8);
            if(number > max) max = number;
            if(number < min) min = number;
            if(max - min >= 5) return false;
        }
        return true;
    }
}
