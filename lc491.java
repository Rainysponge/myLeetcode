package LC;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class lc491 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        DFS(nums,Integer.MIN_VALUE, 0);
        return res;

//        for(int i=0;i<nums.length;i++){
//
//        }
//        return res;

    }

    public void DFS(int[] nums, int end, int index){
        if(index == nums.length){
            if(tmp.size() >= 2){
                res.add(new ArrayList<Integer>(tmp));
            }
            return;
        }
        if(nums[index] >= end){  // 递增
            tmp.add(nums[index]);
            DFS(nums, nums[index], index+1);
            tmp.remove(tmp.size()-1);

        }
        if(nums[index]!=end){
            DFS(nums, end, index+1);
        }

    }

}
