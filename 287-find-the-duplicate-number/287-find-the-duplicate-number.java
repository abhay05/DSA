class Solution {
    public int findDuplicate(int[] nums) {
       int n=nums.length;
        
       int[][] bits=new int[n][31];
        int[] sum=new int[31];
        int[][] bits1=new int[n][31];
        int[] sum1=new int[31];
        for(int i=0;i<n;i++){
            int temp=nums[i];
            int ind=0;
            while(temp!=0){
                bits[i][ind]=temp%2;
                temp/=2;
                ind++;
            }
        }
        
        for(int i=0;i<31;i++){
            int x=0;
            for(int ind=0;ind<n;ind++){
                x+=bits[ind][i];   
            }
            sum[i]=x;
        }
        
        
        for(int i=1;i<=n-1;i++){
            int temp=i;
            int ind=0;
            while(temp!=0){
                bits1[i][ind]=temp%2;
                temp/=2;
                ind++;
            }
        }
        
        for(int i=0;i<31;i++){
            int x=0;
            for(int ind=1;ind<n;ind++){
                x+=bits1[ind][i];   
            }
            sum1[i]=x;
        }
        
        int ans=0;
        for(int ind=0;ind<31;ind++){
            if(sum[ind]>sum1[ind]){
                ans+=(1<<ind);
            }
        }
        return ans;
    }
}