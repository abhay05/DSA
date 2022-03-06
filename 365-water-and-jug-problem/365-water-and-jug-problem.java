class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        int a=jug1Capacity;
        int b=jug2Capacity;
        int c=targetCapacity;
        
        if(a+b==c){
            return true;
        }
        if(a==c || b==c){
            return true;
        }
        if(c<a+b){
            if(a>b){
                int temp=a;
                a=b;
                b=temp;
            }
            HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
            
            Queue<Integer>q= new LinkedList<Integer>();
            int vv=Math.abs(a-b);
            q.add(vv);
            hm.put(vv,1);
            while(q.size()!=0){
            //    System.out.println(q.size());
                int val=q.poll();
           //     System.out.println("val "+val);
                if(val<=a){
                int x=(b-(a-val));
                if(!hm.containsKey(x)){
                    hm.put(x,1);
                    q.add(x);
                }
                }
                int t=b-val;
                int x=a;
                while(val+x<b){
                    if(!hm.containsKey(x+val)){
                    hm.put(x+val,1);
                    q.add(x+val);
                      //  System.out.println("adding "+val+" "+x+" "+b);
                }
                    x+=a;
                }
                if(!hm.containsKey((x+val-b)%b)){
                    hm.put(x+val-b,1);
                    q.add(x+val-b);
                //    System.out.println("adding2 "+val+" "+x+" "+b+" "+(x+val-b));
                }
        }
            if(hm.containsKey(c-a) || hm.containsKey(c-b)){
                return true;
            }
            
            if(hm.containsKey(c)){
                return true;
            }
        
    }
        return false;
    }
}