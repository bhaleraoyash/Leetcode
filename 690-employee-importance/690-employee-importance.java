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
        Map<Integer, Employee> employeeMap = new HashMap<Integer, Employee>();
        Stack<Employee> stack = new Stack<Employee>();
        int answer = 0;
        
        for(Employee e : employees){
            employeeMap.put(e.id, e);
        }
        
        stack.push(employeeMap.get(id));
        
        while(!stack.isEmpty()){
            Employee temp = stack.pop();
            answer += temp.importance;
            for(int empId : temp.subordinates){
                stack.push(employeeMap.get(empId));
            }
        }
        
        return answer;
    }
}