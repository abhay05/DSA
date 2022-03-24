class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int st=-1;
        int end=0;
        for(int i=0;i<flowerbed.length;i++){
            if(flowerbed[i]==1){
                if(end-st>2){
                    n-=(end-st-1)/2;
                }
                st=i;
                end=i;
            }else{
                end++;
            }
                
        }
        if(flowerbed[flowerbed.length-1]==0){end++;}
        if(end-st>2){
                    n-=(end-st-1)/2;
                }
        return n<=0;
    }
}
