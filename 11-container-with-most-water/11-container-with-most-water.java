class Solution {
    public int maxArea(int[] height) {
        int area=0;
         int minIndex=0;
        int maxIndex=height.length-1;
        
       while(minIndex<maxIndex){
           area=Math.max(area,(maxIndex-minIndex)*Math.min(height[minIndex],height[maxIndex]));
           if(height[minIndex]<=height[maxIndex]){
               minIndex++;
           }else{
               maxIndex--;
           }
       }
        
        return area;
    }
}