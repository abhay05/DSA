class Solution {
public:
    bool search(vector<int>& nums, int target) {
        int n=nums.size();
        for(int i=0;i<n;i++){
            if(nums[i]==target){
                return true;
            }
        }
        return false;
//         if(nums.size()==1){
//                 if(nums[0]==target){
//                     return true;
//                 }else{
//                     return false;
//                 }
//         }
        
//         int l=0;
//         int u=nums.size();
//         int pivot=-1;
        
//         int ind=0;
//         while(true){
//             if(ind>0 && nums[ind]<nums[ind-1]){
//                 break;
//             }
//         //    cout<<"ind "<<ind<<'\n';
//             for(int i=1;i<u;i*=2){
//                ind+=i;
//                 if(ind>0 && ind+i<u+1 && nums[ind]<=nums[0]){
//                     ind-=i;
//                     break;
//                 }
//             }
//             ind++;
//         }
//         pivot=ind;
//         //cout<<pivot<<'\n';
//         int val=lower_bound(nums.begin(),nums.begin()+pivot,target)-nums.begin();
//         if(nums[val]==target){
//             return true;
//         }
//         val=lower_bound(nums.begin()+pivot,nums.end(),target)-nums.begin();
//         if(nums[val]==target){
//             return true;
//         }
//         return false;
    }
};