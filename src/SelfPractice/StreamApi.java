package SelfPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//runnable , comparator
//predicate<T> input one argument return boolean value;
 //Function<T,R> takes an argument and produce a result
//Consumer<T> takes an argument and return a result
//Supplier<T> takes an argument and return a result
//Methods in stream API
    // stream() , filter(), map(), flatmap(), distinct(), forEach(), collect() , reduce(), count(), findAny();
//
public class StreamApi {

        public static void main(String[] args) {
            List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
            List<Integer> even = list.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
            System.out.println(even);










    }
}
