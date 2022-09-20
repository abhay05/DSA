class Trie{
    Trie[] ch=new Trie[26];
    int visited;
    Trie(){
        for(int i=0;i<26;i++){
            this.ch[i]=null;
        }
        this.visited=0;
    }
}
class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie trie=new Trie();
        for(int i=0;i<words.length;i++){
            Trie ntrie=trie;
            for(int j=0;j<words[i].length();j++){
                char c=words[i].charAt(j);
                if(ntrie.ch[c-'a']==null){
                    ntrie.ch[c-'a']=new Trie();
                }
                ntrie=ntrie.ch[c-'a'];
                ntrie.visited++;
            }
        }
        int[] ans=new int[words.length];
        for(int i=0;i<words.length;i++){
            Trie ntrie=trie;
            int cnt=0;
            for(int j=0;j<words[i].length();j++){
                char c=words[i].charAt(j);
                
                ntrie=ntrie.ch[c-'a'];
                cnt+=ntrie.visited;
            }
            ans[i]=cnt;
        }
        return ans;
    }
}