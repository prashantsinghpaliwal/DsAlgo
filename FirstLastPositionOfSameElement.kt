// Question Link -> https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// Find First and Last Position of Element in Sorted Array -> *LeetCode Medium Asked in Fb*

class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val positions = intArrayOf(-1, -1)
        positions[0] = findTarget(nums, target, true)
        
        //condition when it is not found once, then why to check?
        if(positions[0] != -1){
          positions[1] =  findTarget(nums, target, false)
        }
        
        return positions
    }
    
    fun findTarget(nums: IntArray, target: Int, findFirstIndex: Boolean) : Int{
        
        var start = 0
        var end = nums.size
        var ans = -1
        
        while(start <= end){
            var mid = start + (end - start)/2
            
            if(mid >= nums.size){
                return ans
            }
            
            if(target < nums[mid]){
                end = mid - 1
            } else if(target > nums[mid]){
                start = mid + 1
            } else {
                // potential ans found
                ans = mid
                if(findFirstIndex){
                    end = mid -1
                } else {
                    start = mid + 1
                }
                
            }
        }
        
        return ans
    }
}
