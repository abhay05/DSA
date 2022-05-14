class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>>mp=new HashMap<String,List<String>>();
        for(int i=0;i<strs.length;i++){
            char[] temp=strs[i].toCharArray();
            Arrays.sort(temp);
            String nstr=new String(temp,0,temp.length);
            if(mp.get(nstr)==null){
                mp.put(nstr,new ArrayList<String>());
            }
                mp.get(nstr).add(strs[i]);
            
        }
        List<List<String>>ans=new ArrayList<List<String>>();
        for(Map.Entry<String,List<String>>pr:mp.entrySet()){
            ans.add(pr.getValue());
        }
        return ans;
    }
}