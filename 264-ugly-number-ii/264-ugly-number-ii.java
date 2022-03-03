class Solution {
    public int nthUglyNumber(int n) {
        List<Integer>arr = new ArrayList<Integer>();
        arr.add(1);
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        hm.put(2,0);
        hm.put(3,0);
        hm.put(5,0);
        for(int i=2;i<=n;i++){
            int x=hm.get(2);
            int y=hm.get(3);
            int z=hm.get(5);
            int val1=arr.get(x)*2;
            int val2=arr.get(y)*3;
            int val3=arr.get(z)*5;
            int val=Math.min(val1,Math.min(val2,val3));
            if(val==val1){
                hm.put(2,(x+1));
            }
            if(val==val2){
                hm.put(3,(y+1));
            }
            if(val==val3){
                hm.put(5,(z+1));
            }
            arr.add(val);
            //System.out.println(val);
        }
        return arr.get(n-1);
        
    }
}