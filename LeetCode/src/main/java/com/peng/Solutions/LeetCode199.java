package com.peng.Solutions;

import com.peng.utils.TreeNode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class LeetCode199 {
    public List<Integer> rightSideView(TreeNode root) {
        TreeNode[] que=new TreeNode[1101];
        int front=0,last=0,pos=0;
        List<Integer>ans=new ArrayList();
        if(root==null){
            return ans;
        }
        que[last++]=root;
        while(front<last){
            TreeNode cur=que[front];
            if(front==pos){
                ans.add(cur.val);
                if(cur.left!=null){
                    que[last++]=cur.left;
                }
                if(cur.right!=null){
                    que[last++]=cur.right;
                }
                pos=last-1;
            }
            else{
                if(cur.left!=null){
                    que[last++]=cur.left;
                }
                if(cur.right!=null){
                    que[last++]=cur.right;
                }
            }
            front++;
        }
        return ans;
    }
}