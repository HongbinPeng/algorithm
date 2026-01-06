package com.peng.Solutions;
import com.peng.utils.TreeNode;
import org.springframework.stereotype.Component;

@Component
public class LeetCode1161 {
    public int maxLevelSum(TreeNode root) {
        TreeNode[]que=new TreeNode[10005];
        int front=0,end=0,tag=1;
        if(root==null){
            return 0;
        }
        que[end++]=root;
        int ans=root.val;
        int tempans=0;
        int cur=1;
        int anscur=1;
        while(front<end){
            TreeNode temp=que[front++];
            tempans=tempans+temp.val;
            if(temp.left!=null){
                que[end++]=temp.left;
            }
            if(temp.right!=null){
                que[end++]=temp.right;
            }
            if(front==tag){
                if(tempans>ans){
                    anscur=cur;
                }
                ans=Math.max(tempans,ans);
                tempans=0;
                cur++;
                tag=end;
            }
        }
        return anscur;
    }
}
