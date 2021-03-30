#
# @lc app=leetcode.cn id=215 lang=python3
#
# [215] 数组中的第K个最大元素
#

# @lc code=start
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # 使用额外空间 快排
        # numsLen = len(nums)
        # def func(left, right):
        #     tmp = nums[left]
        #     i, j = left, right
        #     while i < j:
        #         while i < j and nums[j] <= tmp:
        #             j -= 1
        #         nums[i] = nums[j]
        #         while i < j and nums[i] >= tmp:
        #             i += 1
        #         nums[j] = nums[i]
        #         nums[i] = tmp
        #     if i == k - 1:
        #         return nums[i]
        #     elif i > k - 1:
        #         return func(left, i-1)
        #     else:
        #         return func(i+1, right) 

        # return func(0, len(nums)-1)


        # 堆 O(n) 无需额外空间

        heap = [0]

        def up(num):
            heap.append(num)
            t = len(heap) - 1
            while t:
                if t // 2 and heap[t//2] > heap[t]:
                    heap[t//2], heap[t] = heap[t], heap[t//2]
                t //= 2


        def sink():
            cur = 1
            while cur <= k:
                t = cur * 2
                if t+1 <= k and heap[t+1] < heap[t]:
                    t += 1
                if t <= k and heap[cur] > heap[t]:
                    heap[cur], heap[t] = heap[t], heap[cur]
                    cur = t
                else:
                    break
        
        for num in nums[:k]:
            up(num)
        for num in nums[k:]:
            if heap[1] < num:
                heap[1] = num
                sink()
        return heap[1]

        # # nums.sort()
        # # return nums[-k]
        # heapify(nums)  # 该方法没有返回值
        # # res = 0
        # # # while k:
        # # #     k = k - 1
        # # #     res = heappop(nums)
        # return nlargest(k, nums)[-1]
        # # # return nums



# @lc code=end

