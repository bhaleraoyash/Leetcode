class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int slider = nums1.length - 1;
        
        while(slider >= 0){
            int firstElement = index1 >= 0 ? nums1[index1] : Integer.MIN_VALUE;
            int secondElement = index2 >= 0 ? nums2[index2] : Integer.MIN_VALUE;
            
            if(secondElement > firstElement){
                nums1[slider] = secondElement;
                index2--;
                slider--;
            }
            else{
                nums1[slider] = firstElement;
                index1--;
                slider--;
            }
        }
    }
}