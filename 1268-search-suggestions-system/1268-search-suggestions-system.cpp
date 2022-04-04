class Solution {
public:
    vector<vector<string>> suggestedProducts(vector<string>& products, string searchWord) {
        sort(products.begin(),products.end());
        vector<vector<string>>ans;
        for(int i=1;i<=searchWord.size();i++){
            string temp=searchWord.substr(0,i);
            int ind=lower_bound(products.begin(),products.end(),temp)-products.begin();
            vector<string>tempV;
            for(int j=ind;j<products.size()&&tempV.size()<3;j++){
                if(products[j].substr(0,i)==temp){
                    tempV.push_back(products[j]);
                }else{
                    break;
                }
            }
            ans.push_back(tempV);
        }
        return ans;
    }
};