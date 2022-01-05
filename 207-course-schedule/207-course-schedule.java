class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0){
            return true;
        }
        
        Map<Integer, GNode> graph = new HashMap<Integer, GNode>();
        
        for(int[] relation : prerequisites){
            GNode prevCourse = getCreateGNode(graph, relation[1]);
            GNode nextCourse = getCreateGNode(graph, relation[0]);
            
            prevCourse.outNodes.add(relation[0]);
            nextCourse.inDegrees += 1;
        }
        
        int totalDeps = prerequisites.length;
        LinkedList<Integer> nodepCourses = new LinkedList<Integer>();
        
        for(Map.Entry<Integer, GNode> entry : graph.entrySet()){
            GNode node = entry.getValue();
            if(node.inDegrees == 0){
                nodepCourses.add(entry.getKey());
            }
        }
        
        int removedEdges = 0;
        while(nodepCourses.size() > 0){
            Integer course = nodepCourses.pop();
            
            for(Integer nextCourse : graph.get(course).outNodes){
                GNode childNode = graph.get(nextCourse);
                childNode.inDegrees -= 1;
                removedEdges += 1;
                if(childNode.inDegrees == 0){
                    nodepCourses.add(nextCourse);
                }
            }
        }
        
        if(removedEdges != totalDeps){
            return false;
        }
        else{
            return true;
        }
    }
    
    public GNode getCreateGNode(Map<Integer, GNode> graph, Integer course){
        GNode node = null;
        if(graph.containsKey(course)){
            node = graph.get(course);
        }
        else{
            node = new GNode();
            graph.put(course, node);
        }
        return node;
    }
}

class GNode{
    public Integer inDegrees = 0;
    public List<Integer> outNodes = new LinkedList<Integer>();
}