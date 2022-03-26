union set solution
```
class Solution {
public:
vector<int> findSmallestSetOfVertices(int n, vector<vector<int>>& edges) {
int par[n];
for(int i=0;i<n;i++){
par[i]=i;
}
int edges_size=edges.size();
for(int i=0;i<edges_size;i++){
int m=edges[i][1];
par[m]=edges[i][0];
}
vector<int>ans;
for(int i=0;i<n;i++){
if(par[i]==i){
ans.push_back(i);
}
}
return ans;
}
};
```