struct comp{
    bool operator() (pair<int,string>& a,pair<int,string>& b){
        if(a.first==b.first)return a.second>b.second; // ascending
        return a.first<b.first; //descending
    }
};

class FoodRatings {
public:
    map<string,int>foodRating;
    map<string,string>foodCuisine;
    map<string,priority_queue<pair<int,string>,vector<pair<int,string>>,comp>>mp;
    FoodRatings(vector<string>& foods, vector<string>& cuisines, vector<int>& ratings) {
        for(int i=0;i<foods.size();i++){
            foodRating[foods[i]]=ratings[i];
            foodCuisine[foods[i]]=cuisines[i];
            mp[cuisines[i]].push({ratings[i],foods[i]});
        }
    }
    
    void changeRating(string food, int newRating) {
        foodRating[food]=newRating;
        mp[foodCuisine[food]].push({newRating,food});
    }
    
    string highestRated(string cuisine) {
        string food=mp[cuisine].top().second;
        int rt=mp[cuisine].top().first;
        while(rt!=foodRating[food]){
            mp[cuisine].pop();
             food=mp[cuisine].top().second;
         rt=mp[cuisine].top().first;
        }
        return food;
    }
};

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings* obj = new FoodRatings(foods, cuisines, ratings);
 * obj->changeRating(food,newRating);
 * string param_2 = obj->highestRated(cuisine);
 */