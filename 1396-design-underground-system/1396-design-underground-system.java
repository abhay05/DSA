class UndergroundSystem {
    
    Map<Integer,Pair<Integer,Integer>>start=new HashMap<Integer,Pair<Integer,Integer>>();
    Map<Pair<Integer,Integer>,Pair<Integer,Integer>> stationData=new HashMap<Pair<Integer,Integer>,Pair<Integer,Integer>>();
    

    public UndergroundSystem() {
        
    }
    
    public void checkIn(int id, String stationName, int t) {
        start.put(id,new Pair(stationName,t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<Integer,Integer> d=start.get(id);
        if(stationData.containsKey((new Pair(d.getKey(),stationName)))){
        Pair<Integer,Integer> time=stationData.get(new Pair(d.getKey(),stationName));
        stationData.put(new Pair(d.getKey(),stationName),new Pair(t-d.getValue()+time.getKey(),time.getValue()+1));}
        else{
           stationData.put(new Pair(d.getKey(),stationName),new Pair(t-d.getValue(),1)); 
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        Pair<Integer,Integer>p=stationData.get(new Pair(startStation,endStation));
       // System.out.println(p.getKey()+" "+p.getValue());
        return (double)p.getKey()/(double)p.getValue();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */