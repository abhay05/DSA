class FoodRatings {
public:
    vector<string>foods;
    vector<string>cuisines;
    vector<int>ratings;
    map<string,int>mp;
    map<string,set<pair<int,string>>>highestF;
    map<string,int>highestR;
    FoodRatings(vector<string>& foods, vector<string>& cuisines, vector<int>& ratings) {
        this->foods=foods;
        this->cuisines=cuisines;
        this->ratings=ratings;
        for(int i=0;i<foods.size();i++){
            this->mp[foods[i]]=i;
        }
        
        for(int i=0;i<cuisines.size();i++){
            highestF[cuisines[i]].insert({-ratings[i],foods[i]});
        }
    }
    
    void changeRating(string food, int newRating) {
        
        string cuis=this->cuisines[this->mp[food]];
        highestF[cuis].erase(highestF[cuis].find({-ratings[mp[food]],food}));
        highestF[cuis].insert({-newRating,food});
        ratings[mp[food]]=newRating;
        return ;
    }
    
    string highestRated(string cuisine) {
       // cout<<highestR[]
        pair<int,string>p=*(highestF[cuisine].begin());
        return p.second;
    }
};

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings* obj = new FoodRatings(foods, cuisines, ratings);
 * obj->changeRating(food,newRating);
 * string param_2 = obj->highestRated(cuisine);
 */