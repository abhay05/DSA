class Solution {
    
    int getInd(int[] nums,int num,int midi,int m1){
        int l=0;
        int u=nums.length-1;
        int ans=-1;
        int ans1=nums.length;
        while(l<=u){
            int mid=(l+u)/2;
            if(nums[mid]<=num){
                l=mid+1;
                ans=l;
            }else{
                u=mid-1;
                
            }
        }
        l=0;
        u=nums.length-1;
        while(l<=u){
            int mid=(l+u)/2;
            if(nums[mid]<num){
                l=mid+1;
                
            }else{
                u=mid-1;
                ans1=mid-1;
            }
        }
        // System.out.println(ans1);
        // System.out.println(ans);
        // System.out.println(midi);
        // System.out.println(num);
        if(ans-ans1>1 && m1>ans1+midi && m1<ans+midi){
            return m1-midi;
        }
        if(ans==-1)return 0;
        return ans;
    }
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length-1;
        int m=nums2.length-1;
        int m1=(n+m+1)/2;
        int m2=m1 + 1;
        
        int l=0;
        int u=n;
        int ans1=-1;
        int ans2=-1;
        int ans3=-1;
        int ans4=-1;
        while(l<=u){
            int mid=(l+u)/2;
            int number=nums1[mid];
            int p=getInd(nums2,number,mid,m1);
            // System.out.println(mid);
            // System.out.println(m1);
            // System.out.println(p);
            ans3=p;
            if(p+mid<m1){
                l=mid+1;
            }else if(p+mid>m1){
                u=mid-1;
            }else{
                ans1=mid;break;
            }
        }
      //  System.out.println(ans1);
        if(ans1==-1){
             l=0;
             u=m;
            while(l<=u){
            int mid=(l+u)/2;
            int number=nums2[mid];
            int p=getInd(nums1,number,mid,m1);
            ans4=p;
            if(p+mid<m1){
                l=mid+1;
            }else if(p+mid>m1){
                u=mid-1;
            }else{
                ans2=mid;break;
            }
            }
        }
        if((nums1.length+nums2.length)%2==1){
        if(ans1==-1){
            return nums2[ans2];
        }else{
            System.out.println(ans1);
            return nums1[ans1];
        }
        }else{
          if(ans1==-1){
              // System.out.println(ans2);
              // System.out.println(nums2[ans2]);
              // System.out.println(ans4);
            return (double)(nums2[ans2]+Math.min(ans4<nums1.length?nums1[ans4]:1000000000,ans2+1<nums2.length?nums2[ans2+1]:1000000000))/2;
        }else{
              // System.out.println(ans1);
              // System.out.println(nums1[ans1]);
              // System.out.println(ans3);
            return (double)(nums1[ans1]+Math.min(ans3<nums2.length?nums2[ans3]:1000000000,ans1+1<nums1.length?nums1[ans1+1]:1000000000))/2;
        }  
        }
        
        
    }
}