*** METHOD-1 ***
class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        List<String> validStringList = new ArrayList<String>();
        String validString = "";
        for(int i = 0;i<items.size();i++){
            validStringList = items.get(i);
            if(ruleKey.equals("type")){
                validString = validStringList.get(0);
                if(validString.equals(ruleValue)){
                    count++;
                }
            }else if(ruleKey.equals("color")){
                validString = validStringList.get(1);
                if(validString.equals(ruleValue)){
                    count++;
                }
            }else {
                validString = validStringList.get(2);
                if(validString.equals(ruleValue)){
                    count++;
                }
            }
        }
        
        return count;
    }
}
*** METHOD-2 ***
class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res = 0;
        List<String> key = new ArrayList<>();
        
        key.add("type");
        key.add("color");
        key.add("name");
        
        int val = key.indexOf(ruleKey);
        
        int size = items.size();
        
        for(int i = 0;i<size;i++){
            if( items.get(i).get(val).equals( ruleValue ) ){
                res++;
            }
        }
        
        return res;
    }
}