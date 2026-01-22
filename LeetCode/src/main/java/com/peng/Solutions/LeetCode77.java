package com.peng.Solutions;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class LeetCode77 {
    List<List<Integer>>ans=new ArrayList<List<Integer>>();
    List<Integer>curlist=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        // List<Integer>curlist=new ArrayList<>();
        backtrak(1,k,n);
        return ans;
    }
    public void backtrak(int cur,int k,int n){
        if(curlist.size()==k){
            List<Integer>temp=new ArrayList<>(curlist);
            ans.add(temp);
            return;
        }
        else{
            for(int i=cur;i<=n;i++){
                curlist.add(i);
                backtrak(i+1,k,n);
                curlist.remove(curlist.size()-1);
            }
        }
    }
}
