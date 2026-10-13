class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> common = new ArrayList<>();
        int[] first = new int[1001];
        int[] second = new int[1001];
        for(int i=0;i<nums1.length;i++){
            first[nums1[i]]++;
        }
        for(int i=0;i<nums2.length;i++){
            second[nums2[i]]++;
        }
        for(int i=0;i<1001;i++){
            if(first[i]>0 && second[i]>0){
              int freq =  Math.min(first[i],second[i]);
              for(int j=0;j<freq;j++){
                common.add(i);
              }
            }
        }  
        int[] answer = new int[common.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = common.get(i);
        }
        return answer;
    }
}