package SelfPractice;

import java.util.*;

public class Practice {
    public static void main(String[] args) {
    int arr[] = {1,2,3,0,4,2,2};
    Map<Integer , Integer>freq = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
        if(freq.containsKey(arr[i])) {
            freq.put(arr[i], freq.get(arr[i]) + 1);
        }else{
            freq.put(arr[i], 1);
        }
    }

    for(int i=0;i<arr.length;i++){
        if(freq.containsKey(4-arr[i]) && freq.get(4-arr[i])>=1){
            System.out.println("Pair" + arr[i] + " is " + (4-arr[i]));
            freq.put(arr[i],0);
        }
    }


    }
}
