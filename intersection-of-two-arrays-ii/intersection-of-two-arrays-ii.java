class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> num1 = new ArrayList<Integer>();
        List<Integer> answer = new ArrayList<Integer>();

        for(Integer i : nums1){
            num1.add(i);
        }
        for(int i = 0; i < nums2.length; i++){
            if(num1.contains(nums2[i])){
                num1.remove(num1.indexOf(nums2[i]));
                answer.add(nums2[i]);
            }
        }

        int i = 0;
        int[] intersection = new int[answer.size()];
        for(Integer j : answer){
            intersection[i] = j;
            i++;
        }
        return intersection;
    }
}
