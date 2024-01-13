class Solution {
    public int minSteps(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        int res = 0;
        
        for(Character ch : s.toCharArray()){
            int val = map.getOrDefault(ch,0);
            map.put( ch , ++val );
        }
        
        for(Character ch : t.toCharArray()){
            int val = map.getOrDefault(ch,0);
            map.put( ch , --val );
        }
        
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            int val = entry.getValue();
            
            if(val > 0) res+=val;
        }
        
        return res;
    }
}