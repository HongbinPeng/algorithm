import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        if(n==1){
            return;
        }
        int pos=n-2;
        while(pos>=0){
            if(nums[pos]<nums[pos+1]){
                break;
            }
            pos--;
        }
        int j=n-1;
        while(j>=0&&nums[j]<=nums[pos]){
            j--;
        }
        if(j==pos){
            return ;
        }
        else{
            int temp=nums[pos];
            nums[pos]=nums[j];
            nums[j]=temp;
            Arrays.sort(nums,pos+1,n);
            return;
        }
    }
}