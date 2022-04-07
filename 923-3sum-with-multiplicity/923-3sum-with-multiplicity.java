class Solution {
    public int threeSumMulti(int[] arr, int target) {
        long ans=0;
        long mod=1000000007;
        Arrays.sort(arr);
        int n=arr.length;
        for(int i=0;i<n;i++){
            int j=i+1;
            int k=n-1;
          //  System.out.println(i);
            int tar=target-arr[i];
            while(j<k){
                int sum=arr[j]+arr[k];
                if(sum<tar){
                    j++;
                }else if(sum>tar){
                    k--;
                }else if(sum==tar){
                    int tempj=j;
                    int tempk=k;
                    long cnt1=0;
                    long cnt2=0;
                   // System.out.println(i+" "+j+" "+k);
                    // if(arr[i]==arr[j] && arr[j]==arr[k]){
                    //     ans=(ans+((long)(k-i+1)*(long)(k-i)*(long)(k-i-1))/6)%mod;
                    //     i=k;
                    //     break;
                    // }
                    while(j<n-1 && arr[j]==arr[j+1]){
                        j++;
                        cnt1++;
                    }
                    
                        j++;
                        cnt1++;
                    
                    
                    while(k>i+1 && arr[k]==arr[k-1]){
                        k--;
                        cnt2++;
                    }
                   // if(k>0){
                        k--;
                        cnt2++;
                   // }
                    if(arr[tempj]!=arr[tempk]){
                        ans=(ans+cnt1*cnt2)%mod;
                    }else{
                    //    System.out.println(j+" "+k);
                        ans=(ans+((long)(j-k-2)*(long)(j-k-1))/2)%mod;
                    }
                }
            }
        }
        return (int)ans;
    }
}