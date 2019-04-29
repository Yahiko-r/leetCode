package array;

import java.util.*;

/**
 *
 */
public class TopKFrequentElements {
    /**
     * 统计每个出现的次数(hashmap)，之后对次数排序，
     * 前k个数排序的话，堆排序（优先队列）
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequest(int[] nums,int k){
        List<Integer> list=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            //记住->getOrDefault(n,0)
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        //从小到大排序
        PriorityQueue<Integer> heap=new PriorityQueue<>((n1,n2)->map.get(n1)-map.get(n2));

        for(int n:map.keySet()){
            heap.add(n);
            if(heap.size()>k){
                heap.poll();
            }
        }

        while(!heap.isEmpty()){
            list.add(heap.poll());
            Collections.reverse(list);

        }
        return list;

    }
}
