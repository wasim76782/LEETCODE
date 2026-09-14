class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int areaR1 = (ax2 - ax1)*(ay2 - ay1);
        int areaR2 = (bx2 - bx1)*(by2 - by1);

        int commonx1 = Math.max(ax1,bx1),commony1 = Math.max(ay1,by1);
        int commonx2 = Math.min(ax2,bx2),commony2 = Math.min(ay2,by2);

        int commonLength = (commonx2-commonx1);
        int commonHeight = (commony2-commony1);

        int commonArea = 0;
        if(commonLength > 0 && commonHeight>0){
            commonArea = commonLength*commonHeight;
        }
        return areaR1+areaR2-commonArea;
    }
}