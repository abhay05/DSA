import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
    
    List<List<Integer>> recur(int[] candidates,int ind, int target,List<Integer> list){
       
        if(target==0){
            List<List<Integer>> larr=new ArrayList<List<Integer>>();
            List<Integer> temp=new ArrayList<Integer>(); 
            for(int a:list){
                    temp.add(a);
                }
            larr.add(temp);
            return larr;
        }
        if(ind >=candidates.length){
            return new ArrayList<List<Integer>>(); 
            
        }
        int rem=target;
        List<List<Integer>> v1=recur(candidates,ind+1,rem,list);
        int cnt=target/candidates[ind];
        for(int i=1;i<=cnt;i++){
            rem=target;
            for(int j=1;j<=i;j++){
                rem-=candidates[ind];
                list.add(candidates[ind]);
            }
           List<List<Integer>> v2= recur(candidates,ind+1,rem,list);
            if(v2.size()>0){
                for(List<Integer> a:v2){
                    v1.add(a);
                }
            }
            for(int j=1;j<=i;j++){
                rem+=candidates[ind];
                list.remove(list.size()-1);
            }
        }
        return v1;
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       return recur(candidates,0,target,new ArrayList<Integer>());
        
    }
}