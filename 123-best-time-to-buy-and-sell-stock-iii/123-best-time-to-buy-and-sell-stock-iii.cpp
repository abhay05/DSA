class Solution {
public:
    
    int maxProfit(vector<int>& prices) {
        int n=prices.size();
        int ind=0;
        long long arr[n][2];
        long long arr1[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=(long long)0;
            arr[i][1]=(long long)0;
            arr1[i][0]=(long long)0;
            arr1[i][1]=(long long)0;
        }
        
        arr[0][0]=-(long long)prices[0];
        arr[0][1]=-(long long)prices[0];
        arr1[0][0]=(long long)0;
        
        for(int i=1;i<n;i++){
            arr[i][0]=max(arr[i-1][0],-(long long)prices[i]);
            arr1[i][0]=max(arr1[i-1][0],arr[i-1][0]+(long long)prices[i]);
            arr[i][1]=max(arr[i-1][1],arr1[i-1][0]-(long long)prices[i]);
            arr1[i][1]=max(arr1[i-1][1],arr[i-1][1]+(long long)prices[i]);
            
           // cout<<arr[i][0]<<' '<<arr1[i][0]<<' '<<arr[i][1]<<' '<<arr1[i][1]<<'\n';
        }
        
        return (int)max(arr1[n-1][0],arr1[n-1][1]);
    }
};