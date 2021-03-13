/*
 * @lc app=leetcode.cn id=1 lang=cpp
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        // map<int,int>value_index;
        // for(int i=0;i<nums.size();++i){
        // if(value_index.find(target-nums[i])==value_index.end())
        //     value_index[nums[i]]=i;
        // else
        //     return {value_index[target-nums[i]],i};
        // }
        // return {};

        map<int, int> hash_table;
        for(int i=0;i<nums.size();i++)
        {
            if(hash_table.find(target-nums[i])==hash_table.end())
                hash_table[nums[i]] = i;
            else
                return {hash_table[target-nums[i]], i};
        }
        return {};

    }
};
// @lc code=end

