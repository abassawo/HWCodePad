package nyc.c4q.abassawo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by c4q-Abass on 11/4/15.
 */
public class AlgorithmPad {
    public static int majority;

    /* - x^62 can be computed with only 8 multiplications
    because x^62 is same as x^20 * x ^42
  which can be further broken down into [x^20]* [ x^20  * x^20 * x^2]
= (x^20)^3 * x^2. orrr  ((x^4)*(x*5)^3 * x^2
     Can keep breaking it down further */

    public static void main(String[] args) {
        System.out.println(findMajorityElement(new int[]{4, 4, 4, 4, 4, 3, 2, 2, 1}));
    }

    public static int findMajorityElement(int[] set){
        Arrays.sort(set);
        Map<Integer, Integer> numberMap = new HashMap<Integer, Integer>(set.length);
        for (int i = 0; i < set.length ; i++) {
           if(numberMap.get(set[i]) == null){
               numberMap.put(set[i], 1);
           } else {
              int count = numberMap.get(set[i]);
               count++;
               if(count > (set.length / 2)){
                   majority = set[i];
               }
               numberMap.put(set[i], count);
           }
        }

        return majority;
    }

}
