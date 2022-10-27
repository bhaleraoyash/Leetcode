class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> answer = new ArrayList<List<String>>();
        Map<String, List<String>> contentPath = new HashMap<String, List<String>>();
        
        for(int i = 0; i < paths.length; i++){
            String[] parts = paths[i].split(" ");
            String path = parts[0];
            for(int j = 1; j < parts.length; j++){
                String[] temp = parts[j].split("\\(");
                String name = temp[0];
                String content = temp[1].substring(0, temp[1].length() - 1);
                String pathName = path + "/" + name;
                if(contentPath.containsKey(content)){
                    contentPath.get(content).add(pathName);
                }
                else{
                    List<String> pathsList = new ArrayList<String>();
                    pathsList.add(pathName);
                    contentPath.put(content, pathsList);
                }
            }
        }
        
        for(String s : contentPath.keySet()){
            if(contentPath.get(s).size() > 1){
                answer.add(contentPath.get(s));
            }
        }
        
        return answer;
    }
}