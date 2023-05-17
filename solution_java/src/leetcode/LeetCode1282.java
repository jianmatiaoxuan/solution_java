package leetcode;

import java.util.*;

/**
 * @author: sunmengjin
 * @create: LeetCode1282.class 2022-08-12-16 16:40
 **/
public class LeetCode1282 {
    public static void main(String[] args) {
        System.out.println(groupThePeople(new int[]{2,1,3,3,3,2}));
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        int size = groupSizes.length;

        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            if (map.get(groupSizes[i]) == null) {
                LinkedList<Integer> linkedList = new LinkedList<>();
                linkedList.add(i);
                map.put(groupSizes[i], linkedList);
            } else {
                map.get(groupSizes[i]).add(i);
            }
        }

        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for (Map.Entry<Integer, LinkedList<Integer>> integerListEntry : map.entrySet()) {
            LinkedList<Integer> values = integerListEntry.getValue();
            while (!values.isEmpty()) {
                list.add(values.poll());
                if (list.size() == integerListEntry.getKey()) {
                    res.add(list);
                    list = new ArrayList<>();
                }
            }
        }
        return res;
    }
}
