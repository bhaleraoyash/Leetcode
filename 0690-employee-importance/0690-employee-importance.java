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
        int answer = 0;
        Map<Integer, Employee> importance = new HashMap<Integer, Employee>();
        Stack<Employee> stack = new Stack<Employee>();
        
        for(int i = 0; i < employees.size(); i++){
            importance.put(employees.get(i).id, employees.get(i));
        }
        
        stack.push(importance.get(id));
        while(!stack.isEmpty()){
            Employee e = stack.pop();
            answer += e.importance;
            for(int emp : e.subordinates){
                stack.push(importance.get(emp));
            }
        }
        
        return answer;
    }
}