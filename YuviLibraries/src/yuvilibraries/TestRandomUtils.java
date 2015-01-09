/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yuvilibraries;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author yoovrajshinde
 */
public class TestRandomUtils {
    public static void main(String[] args) throws IOException {
        
        
        long start = System.currentTimeMillis();
        BufferedReader br = 
                new BufferedReader(
                        new FileReader("/Users/yoovrajshinde/facebook/new_years_resolution_example_input.txt"));
        
//        BufferedWriter bw = 
//                new BufferedWriter(
//                        new FileWriter("/Users/yoovrajshinde/facebook/output.txt"));
        String line;
        boolean first=true;
        int T = 0;
        int i=1;
        int G_P=0, G_C=1, G_F=2;
        while((line = br.readLine()) != null || T<0 ) {
            // T, the number of test cases
            if (first) {
                T = Integer.valueOf(line);
                first = false;
                continue;
            }
            
            //GP, GC, and GF
            int[] G = toIntArray(line.split(" "));
            
            //the number of foods for that test case, an integer N
            line = br.readLine();
            int N = Integer.valueOf(line);
            int[] P = new int[N];
            int[] C = new int[N];
            int[] F = new int[N];
            
            //N lines each consist of three space-separated integers: P, C, and F
            for (int n = 0 ; n < N ; n++) {
                line = br.readLine();
                int[] tmp = toIntArray(line.split(" "));
                P[n] = tmp[G_P];
                C[n] = tmp[G_C];
                F[n] = tmp[G_F];
            }
            // process 
            
            boolean result = true;
            System.out.println("Case #" + i + ": "  + (result ? "yes" : "no"));
            
            i++;
        }
        long processedTime = System.currentTimeMillis() - start;
        System.out.println(processedTime);
        System.out.println("ms");

        br.close();
//        bw.close();
        System.exit(0);
        int[] mainSet = {1, 2, 3};
        int size = 2;
        Set<String> exaustibleSet = new HashSet<>();
        
        boolean exhausted = false;
        while (!exhausted) {
            int[] index = RandomUtils.getRandomSet(mainSet, size);
            Arrays.sort(index);
            exaustibleSet.add(StringUtils.join(index, ' ').replace(" ", ""));
            if (exaustibleSet.size() == nCk(3, 2)) {
                // exhausted 
                exhausted = true;
                break;
            }
        }
        
        for (String s : exaustibleSet) {
            System.out.println("--" + s);
        }
        
    }
    public static int[] toIntArray(String[] strArray) {
        int[] intArray = new int[strArray.length];
        for(int i=0; i<intArray.length; i++) {
            intArray[i] = Integer.valueOf(strArray[i]);
        }
        return intArray;
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
}
