class Solution {
public:
    int maxProfit(int k, vector<int>& prices) {
        if(prices.size()==0 || k==0)return 0;
        int n=prices.size();
        int arr[n][k];
        int arr1[n][k];
        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++){
                arr[i][j]=0;
                arr1[i][j]=0;
            }
        }
        
        for(int i=0;i<k;i++){
            arr[0][i]=-prices[0];
        }
        
        for(int i=1;i<n;i++){
            arr[i][0]=max(arr[i-1][0],-prices[i]);
            arr1[i][0]=max(arr1[i-1][0],arr[i-1][0]+prices[i]);
            for(int j=1;j<k;j++){
                arr[i][j]=max(arr[i-1][j],arr1[i-1][j-1]-prices[i]);
                arr1[i][j]=max(arr1[i-1][j],arr[i-1][j]+prices[i]);
            }

        }
        
        int ans=0;
        for(int i=0;i<k;i++){
            ans=max(ans,arr1[n-1][i]);
        }
        
        return ans;
    }
};