public class Node{
    boolean isEnd=false;
    Node[] letter=new Node[26];
    List<String>suggestions=new ArrayList<>();
    Node(){
        this.isEnd=false;
        for(int i=0;i<26;i++){
            this.letter[i]=null;
        }
    }
}

class Solution {
    
    List<String> traverse(Node node){
        
            boolean flag=false;
            for(int i=0;i<26;i++){
                if(node.letter[i]!=null){
                    flag=(flag|true);
                }
            }
            if(!flag){
                List<String> temp= new ArrayList<>();
            temp.add("");
                return temp;
            }
            
        
        List<String> ans=new ArrayList<>();
        for(int i=0;i<26;i++){
            if(node.letter[i]!=null){
               // System.out.println("is End "+node.isEnd + "  char "+(char)('a'+i));
                if(node.isEnd){
                    ans.add("");
                }
               List<String> tempArr= traverse(node.letter[i]); 
                for(String st:tempArr){
                    ans.add((char)(i+'a')+st);
                }
            }
        }
        return ans;
    }
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node head=new Node();
        for(int i=0;i<products.length;i++){
            Node curr=head;
            for(int j=0;j<products[i].length();j++){
                if(curr.letter[products[i].charAt(j)-'a']==null){
                Node temp= new Node();
                curr.letter[products[i].charAt(j)-'a']=temp;
                
                curr=temp;}
                else{
                    curr=curr.letter[products[i].charAt(j)-'a'];
                }
                curr.suggestions.add(products[i]);
                Collections.sort(curr.suggestions);
                if(curr.suggestions.size()>3){
                    curr.suggestions.remove(curr.suggestions.size()-1);
                }
            }
            curr.isEnd=true;
        }
        
        List<List<String>> ans=new ArrayList<>();
        Node curr=head;
        for(int i=0;i<searchWord.length();i++){
            char ch=searchWord.charAt(i);
            int cnt=0;
            List<String> temp=new ArrayList<>();
            temp=curr==null?Arrays.asList():curr.suggestions;
            ans.add(temp);
            if(curr!=null)
            curr=curr.letter[ch-'a'];
            
        }
        List<String> temp=new ArrayList<>();
        temp=curr==null?Arrays.asList():curr.suggestions;
        ans.add(temp);
        ans.remove(0);
        return ans;
    }
}