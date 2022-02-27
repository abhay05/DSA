class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        
        int area1=(ax2-ax1)*(ay2-ay1);
        int area2=(bx2-bx1)*(by2-by1);
        int area3=0;
        int cx1=Math.max(ax1,bx1);
        int cx2=Math.min(bx2,ax2);
        int cy1=Math.max(by1,ay1);
        int cy2=Math.min(by2,ay2);
        if((cx1>cx2 || cy1>cy2)){
            
        }else{
            area3=(cx1-cx2)*(cy1-cy2);
        }
        if(area3<0){
        area3=(-1)*area3;}
       // System.out.println(area1+" "+area2+" "+area3);
        return area1+area2-area3;
        
    }
}