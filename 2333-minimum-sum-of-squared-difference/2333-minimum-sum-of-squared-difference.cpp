class Solution {
public:
    long long minSumSquareDiff(vector<int>& nums1, vector<int>& nums2, int k1, int k2) {
        int t=k1+k2;
        int n=nums1.size();
        map<int,int>mp;
        for(int i=0;i<n;i++){
            mp[abs(nums1[i]-nums2[i])]++;
        }
        long long ans=0;
        priority_queue<pair<int,int>>pq;
        for(auto& e:mp){
            if(e.first>0){
            pq.push({e.first,e.second});}
        }
        while(pq.size()>0 && t>0){
            pair<int,int>p=pq.top();
            pq.pop();
            int val=p.first;
            int cnt=p.second;
           // cout<<"ff "<<val<<' '<<cnt<<' '<<t<<'\n';
            if(cnt>=t){
                cnt-=t;
                int cnt1=t;
                int val1=val-1;
                if(val1>0){
                    if(pq.size()>0){
                    pair<int,int>p1=pq.top();
                    if(p1.first==val1){
                        pq.pop();
                        pq.push({val1,p1.second+cnt1});
                    }
                        else{
                             pq.push({val1,cnt1});
                        }
                }else{
                pq.push({val1,cnt1});
                    }
                }
                pq.push({val,cnt});
                t=0;
            }else{
                t-=cnt;
                val--;
                if(val>0){
                if(pq.size()>0){
                    pair<int,int>p1=pq.top();
                    if(p1.first==val){
                        pq.pop();
                        pq.push({val,p1.second+cnt});
                    }else{
                        pq.push({val,cnt});
                    }
                }else{    
                pq.push({val,cnt});
                }
                }
            }
        }
        
        while(pq.size()>0){
            pair<int,int>p=pq.top();
            pq.pop();
            int val=p.first;
            int cnt=p.second;
           // cout<<val<<' '<<cnt<<'\n';
            ans+=((long long)val*(long long)val*(long long)cnt);
        }
        return ans;
    }
};