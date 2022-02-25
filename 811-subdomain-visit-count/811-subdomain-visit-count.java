class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> counter = new HashMap<String, Integer>();
        List<String> answer = new ArrayList<String>();
        
        for(int i = 0; i < cpdomains.length; i++){
            String[] parts = cpdomains[i].split("\\s+");
            int count = Integer.valueOf(parts[0]);
            counter.put(parts[1], counter.getOrDefault(parts[1], 0) + count);
            String[] domains = parts[1].split("\\.");
            if(domains.length == 3){
                String part1 = domains[1] + "." + domains[2];
                counter.put(part1, counter.getOrDefault(part1, 0) + count);
                counter.put(domains[2], counter.getOrDefault(domains[2], 0) + count);
            }
            else{
                counter.put(domains[1], counter.getOrDefault(domains[1], 0) + count);
            }
        }
        
        for(String s : counter.keySet()){
            String temp = counter.get(s) + " " + s;
            answer.add(temp);
        }
        
        return answer;
    }
}