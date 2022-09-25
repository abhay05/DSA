class Solution {
public:
    int MOD=1000000007;
    int peopleAwareOfSecret(int n, int delay, int forget) {
        long long arr[n];
        long long ans[n];
        for(int i=0;i<n;i++){
            arr[i]=(long long)0;
            ans[i]=(long long)0;
        }
        int cnt=1;
        arr[0]=(long long)0;
        ans[0]=(long long)1;
        if(delay<n){
            arr[delay]+=(long long)1;
            }
            if(forget<n){
            arr[forget]-=(long long)1;
                ans[forget]=(long long)-1;
            }
        for(int i=1;i<n;i++){
                arr[i]=(arr[i]+arr[i-1])%MOD;
            if(i+delay<n){
            arr[i+delay]=(arr[i+delay]+arr[i]);
                
            }
            if(i+forget<n){
            arr[i+forget]=(arr[i+forget]-arr[i]);
            }
        }
        for(int i=max(0,n-forget)+1;i<n;i++){
            arr[i]=(arr[i]+arr[i-1])%MOD;
        }
        
        if(forget>=n){
            arr[n-1]=(arr[n-1]+1)%MOD;
            
        }
        if(arr[n-1]<0){
            arr[n-1]=(arr[n-1]+MOD)%MOD;
        }
        return (int)arr[n-1];
    }
};