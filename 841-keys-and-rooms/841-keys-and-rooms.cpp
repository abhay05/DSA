class Solution {
public:
    bool canVisitAllRooms(vector<vector<int>>& rooms) {
        vector<bool>vis(rooms.size()+1,false);
        queue<int>q;
        q.push(0);
        int cnt=0;
        while(!q.empty()){
            int p=q.front();
            q.pop();
            if(!vis[p]){
            cnt++;}
          //  cout<<p<<' ';
            vis[p]=true;
            for(int i=0;i<rooms[p].size();i++){
                if(!vis[rooms[p][i]]){
                    q.push(rooms[p][i]);
                    
                }
            }
        }
        int n=rooms.size();
        //cout<<'\n'<<cnt<<'\n';
        if(cnt>=n){
            return true;
        }else{
            return false;
        }
    }
};