import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
    
    List<List<Integer>> recur(int[] candidates,int ind, int target,List<Integer> list){
       
        if(target==0){
            List<List<Integer>> larr=new ArrayList<List<Integer>>(); 
            // System.out.println("end");
            // System.out.println(list);
            List<Integer> temp=new ArrayList<Integer>(); 
            for(int a:list){
                    temp.add(a);
                }
            larr.add(temp);
            // System.out.println(larr);
            return larr;
        }
        if(ind >=candidates.length){
            return new ArrayList<List<Integer>>(); 
            
        }
        int rem=target;
      //  int i=0;
        List<List<Integer>> v1=recur(candidates,ind+1,rem,list);
        // System.out.println(v1);
        // System.out.println("HHH");
        // System.out.println(ind);
        int cnt=target/candidates[ind];
        for(int i=1;i<=cnt;i++){
            rem=target;
            for(int j=1;j<=i;j++){
                rem-=candidates[ind];
                list.add(candidates[ind]);
            }
          //  System.out.println((recur(candidates,ind+1,rem,list)));
            //v1.addAll((recur(candidates,ind+1,rem,list)));
           //v1= ListUtils.union(v1,recur(candidates,ind+1,rem,list));
           List<List<Integer>> v2= recur(candidates,ind+1,rem,list);
            // System.out.println(v2);
            // System.out.println(v2.size());
            if(v2.size()>0){
                // System.out.println(v2.size());
                // System.out.println("Hello");
                for(List<Integer> a:v2){
                    v1.add(a);
                }
            }
            // System.out.println(v1);
            // System.out.println(ind);
            for(int j=1;j<=i;j++){
                rem+=candidates[ind];
                list.remove(list.size()-1);
            }
        }
      //  System.out.println(v1);
        return v1;
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       return recur(candidates,0,target,new ArrayList<Integer>());
        
    }
}