package com.peng.Solutions;

import org.springframework.stereotype.Component;

@Component
public class LeetCode33 {
    public static class Solution {
        public int search(int[] nums, int target) {
            int l=0,r=nums.length-1;
            while(l<=r){
                int mid=(l+r)/2;
                if(nums[mid]==target){
                    return mid;
                }
                if(nums[mid]>=nums[l]){
                    if(target<nums[mid]&&target>=nums[l]){
                        r=mid-1;
                        continue;
                    }
                    else{
                        l=mid+1;
                    }
                }
                else{
                    if(target>nums[mid]&&target<=nums[r]){
                        l=mid+1;
                    }
                    else{
                        r=mid-1;
                    }
                }
            }
            return -1;
        }
    }
}
