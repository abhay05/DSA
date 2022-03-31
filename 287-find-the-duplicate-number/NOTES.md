Tortoise and Hare approach - O(1) space , O(n) time - ideal
```
class Solution {
    public int findDuplicate(int[] nums) {
        int slow=0;
        int fast=0;
        slow=nums[slow];
        fast=nums[nums[fast]];
        while(nums[slow]!=nums[fast]){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        int ans=0;
        while(nums[slow]!=nums[ans]){
            slow=nums[slow];
            ans=nums[ans];
        }
        return nums[ans];
    }
}
```

Beautiful Pigeon Hole Principle -> O(1) space, O(nlogn) time

```
class Solution {
    public int findDuplicate(int[] nums) {
        int l=1;
        int u=nums.length-1;
        int ans=-1;
        while(l<u){
            int mid=(l+u)/2;
            int cnt=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]<=mid){
                    cnt++;
                }
            }
            if(cnt>mid){
                u=mid;
            }
            else{
                l=mid+1;
            }
            
            
        }
        return l;
    }
}
```


Bitset - time -> O(N*c) ; space -> O(N*c)

```
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
```

