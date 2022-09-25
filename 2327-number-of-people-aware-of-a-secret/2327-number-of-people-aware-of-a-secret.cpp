class Solution {
public:
    int MOD=1000000007;
    int peopleAwareOfSecret(int n, int delay, int forget) {
        int arr[n];
        int ans[n];
        for(int i=0;i<n;i++){
            arr[i]=0;
            ans[i]=0;
        }
        int cnt=1;
        arr[0]=0;
        ans[0]=1;
        if(delay<n){
            arr[delay]+=1;
            }
            if(forget<n){
            arr[forget]-=1;
                ans[forget]=-1;
            }
        for(int i=1;i<n;i++){
            
                arr[i]=((arr[i]+MOD)%MOD+(arr[i-1]+MOD)%MOD)%MOD;
            ans[i]=(ans[i]+(arr[i]+ans[i-1])%MOD)%MOD;
            if(ans[i]<0){ans[i]=(ans[i]+MOD)%MOD;}
            if(i+delay<n){
            arr[i+delay]+=arr[i];
            }
            if(i+forget<n){
            arr[i+forget]-=arr[i];
                ans[i+forget]-=arr[i];
            } 
        }
        
        return ans[n-1];
    }
};