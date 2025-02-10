package CollectionDemo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class MostFrequentElement {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(3);
        list.add(3);
        MostFrequentElement mostFrequentElement = new MostFrequentElement();
        System.out.println(mostFrequentElement.mostFrequent(list).toString());
    }
    private Integer mostFrequent(List<Integer> list) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i =0 ; i<list.size(); i++){
            if(freq.containsKey(list.get(i))){
                freq.put(list.get(i), freq.get(list.get(i)) + 1);
            }else{
                freq.put(list.get(i), 1);
            }
        }
        int max = 0;
        int element = 0;
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            if(entry.getValue() > max) {
                max = entry.getValue();
                element = entry.getKey();
            }
        }
        return element;
    }
}
