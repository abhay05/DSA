class Solution {
    
    int calGCD(int a,int b){
       // System.out.println(a+" "+b);
        if(b==0){return a;}
        return calGCD(b,a%b);
        
    }
    
    public boolean isGoodArray(int[] nums) {
        int a=nums[0];
        if(a==1)return true;
        for(int i=1;i<nums.length;i++){
           int g=calGCD(nums[i],a);
            if(g==1)return true;
            a=g;
        }
        return false;
    }
}