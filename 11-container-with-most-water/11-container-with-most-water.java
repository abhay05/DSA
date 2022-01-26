class Solution {
    public int maxArea(int[] height) {
        int area=0;
        
        for(int i=0;i<height.length;i++){
            int minIndex=i;
        int maxIndex=i;
            int newHeight=height[i];
            for(int j=0;j<i;j++){
                if(height[j]>=newHeight){
                    minIndex=j;
                    break;
                }
            }
            for(int j=height.length-1;j>i;j--){
                if(height[j]>=newHeight){
                    maxIndex=j;
                    break;
                }
            }
            // System.out.println(i);
            // System.out.println((i-minIndex)*newHeight);
            area=Math.max(area,Math.max((i-minIndex)*newHeight,(maxIndex-i)*newHeight));
        }
        return area;
    }
}