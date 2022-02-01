/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Stack<Employee> stack = new Stack<Employee>();
        Map<Integer, Employee> map = new HashMap<Integer, Employee>();
        int answer = 0;
        
        for(Employee e : employees){
            map.put(e.id, e);
        }
        
        stack.push(map.get(id));
        
        while(!stack.isEmpty()){
            Employee temp = stack.pop();
            answer += temp.importance;
            
            for(int i : temp.subordinates){
                stack.push(map.get(i));
            }
        }
        
        return answer;
    }
}