public class Solution {
public List<String> letterCombinations(String digits) {
		LinkedList<String> list=new LinkedList<String>();
        if(digits.isEmpty())return list;
        list.add("");
        String[] mapping=new String[]{"0","1","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for(int i=0;i<digits.length();i++){
            int ind=Character.getNumericValue(digits.charAt(i));
            while(list.peek().length()==i){
                String x=list.peek();
                list.poll();
                for(int j=0;j<mapping[ind].length();j++){
                    //ans.poll();
                    list.add(x+mapping[ind].charAt(j));
                }
            }
        }
        return list;
    
}
}    