package CollectionDemo;
import java.util.*;
public class RemoveDuplicate {
    public List<Integer> removeDuplicates(List<Integer> nums) {

        Collections.sort(nums);
        List<Integer> result = new ArrayList<>();
        for(int i=0 ; i<nums.size()-1; i++){
                if(Objects.equals(nums.get(i), nums.get(i + 1))){
                    continue;
                }
                result.add(nums.get(i));
        }
        if(!Objects.equals(nums.getLast(), nums.get(nums.size() - 2))){
            result.add(nums.getLast());
        }
        return result;
    }
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(2);
        list1.add(4);
        list1.add(5);
        RemoveDuplicate obj = new RemoveDuplicate();
        System.out.println(obj.removeDuplicates(list1).toString());
    }
}
