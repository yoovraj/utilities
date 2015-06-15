/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yuvilibraries;

import java.util.Random;

/**
 *
 * @author yoovrajshinde
 */
public class RandomUtils {
    public static int[] getRandomSet(int[] mainSet, int size) {
        int index[] = new int[size];
        for(int j=0;j <size; j++) {
            index[j] = -1;
        }
        int i=0;
        int loop = 0;
        while (i<=size-1) {
            int tmp = randInt(0,mainSet.length-1);
            boolean duplicate = false;
            for(int t : index) {
                if (t == tmp) {
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) {
                index[i] = tmp;                
//                System.out.println(index[i]);
                i++;
            }
            loop++;
        }
//        System.out.println("Looped " + loop + " times");
        
        int[] subSet = new int[size];
        for (int j=0; j < size; j++) {
            subSet[j] = mainSet[index[j]];
        }
        return subSet;
    }
    public static int nCk (int n, int k) {
        if (k > n/2) {
            k = n - k;
        }
        int num=1, den=1 ;
        for (int t = 1; t <= k; t++) {
            num *= n;n--;
            den *= t;
        }
        return num/den;
    }

/**
 * Returns a pseudo-random number between min and max, inclusive.
 * The difference between min and max can be at most
 * <code>Integer.MAX_VALUE - 1</code>.
 *
 * @param min Minimum value
 * @param max Maximum value.  Must be greater than min.
 * @return Integer between min and max, inclusive.
 * @see java.util.Random#nextInt(int)
 */
public static int randInt(int min, int max) {

    // NOTE: Usually this should be a field rather than a method
    // variable so that it is not re-seeded every call.
    Random rand = new Random();

    // nextInt is normally exclusive of the top value,
    // so add 1 to make it inclusive
    int randomNum = rand.nextInt((max - min) + 1) + min;

    return randomNum;
}    
}
