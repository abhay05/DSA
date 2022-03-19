class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        int x=arr1[0];
        int y=arr2[0];
        for(int i=1;i<arr1.length;i++){
            x=(x^arr1[i]);
        }
        for(int i=1;i<arr2.length;i++){
            y=(y^arr2[i]);
        }
        return (x&y);
    }
}