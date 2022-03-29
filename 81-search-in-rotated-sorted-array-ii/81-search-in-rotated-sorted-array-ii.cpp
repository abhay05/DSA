class Solution {
public:
    bool search(vector<int>& nums, int target) {
        int n=nums.size();
        int l=0;
        int u=n-1;
        while(l<=u){
            int mid=(l+u)/2;
            int value=nums[mid];
         //   cout<<l<<' '<<mid<<' '<<u<<' '<<value<<'\n';
            if(target==value){
                return true;
            }else if(nums[l]==value){
                l++;
            }else if(nums[u]==value){
                u--;
            }
            else if(target>value){
                if(value<nums[u] && target>nums[u]){
                    u=mid-1;
                }else if(target==nums[u]){
                    return true;
                }else{
                    l=mid+1;
                    
                }
            }else if(target<value){
//                 if(value<nums[l]){
//                     l=mid+1;
                    
//                 }else 
                if(value>nums[l] && target<nums[l]){
                    l=mid+1;
                }else if(target==nums[l]){
                    return true;
                }else{
                    u=mid-1;
                }
            }
        }
        return false;
    }
};