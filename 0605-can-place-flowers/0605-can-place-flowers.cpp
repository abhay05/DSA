class Solution {
public:
    bool canPlaceFlowers(vector<int>& flowerbed, int n) {
        for(int i=0;i<flowerbed.size();i++){
            int x=1;
            int y=1;
            int z=1;
            if(i>0 && flowerbed[i-1]==1){
                x=0;
            }
            if(i<flowerbed.size()-1 && flowerbed[i+1]==1){
                y=0;
            }
            if(flowerbed[i]==1){
                z=0;
            }
         //   cout<<x<<' '<<y<<' '<<z<<'\n';
            if(x&y&z){
                flowerbed[i]=1;
                n--;
            }
        }
        
        return (n<=0?true:false);
    }
};