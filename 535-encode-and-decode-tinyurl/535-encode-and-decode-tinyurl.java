public class Codec {
    
    Map<String,String>mp=new HashMap<String,String>();
    String base62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        
        // calculate md5 hash
        // MessageDigest md= MessageDigest.getInstance("MD5");
        // byte[] messageDigest=md.digest(longUrl.getBytes());
        // BigInteger big=new BigInteger(1,messageDigest);
        // String hashtext = big.toString(16);
        //     while (hashtext.length() < 32) {
        //         hashtext = "0" + hashtext;
        //     }
        //     //return hashtext;
        // System.out.println(hashtext);
        
        // encode md5 hash with base62;
        String hashtext=longUrl;
        StringBuilder sb=new StringBuilder();
        for(char e:hashtext.toCharArray()){
            int ind=((int)e % 62);
            sb.append(base62.charAt(ind));
            
        }
        
        while (sb.length() < 7) {
        sb.append(0);
        }
        
        String shortUrl=sb.substring(0,7);
        String ans="http://tinyurl.com/"+shortUrl;
        mp.put(ans,longUrl);
        return ans;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return mp.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));