class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        map<int,int>mp;
        int ans=0;
        for(int i=0;i<nums.size();i++){
            mp[nums[i]]=1;
        }
        int cnt=0;
        for(auto e:mp){
            int a=e.first;
            int b=e.second;
            if(mp[a-1]>0){
                cnt++;
            }else{
                cnt=1;
            }
            ans=max(ans,cnt);
        }
        return ans;
    }
};