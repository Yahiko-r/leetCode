public class TrappingRainWater {
    //正序一遍，倒序一遍
    public int trap(int[] height){
        int p1=0,p2=0,sum=0;
        int l=height.length;
        while(p2<l){
            if(height[p1]<height[p2]){
                for(int i=p1+1;i<p2;i++){
                    sum+=height[p1]-height[i];
                }
                p1=p2;
            }
            p2++;
        }
        int max=p1;
        p1=p2=l-1;
        while(p2>=max){
            if(height[p1]<=height[p2]){
                for(int i=p1-1;i>p2;i--){
                    sum+=height[p1]-height[i];
                }
                p1=p2;
            }
            p2--;
        }
        return sum;
    }

    //左右同时走
    public int trap2(int[] height){
        if (height == null || height.length == 0) return 0;

        int left = 0;
        int right = height.length - 1;

        int leftMax = height[0];
        int rightMax = height[height.length - 1];

        int result = 0;

        while(left <= right) {
            if (leftMax <= rightMax) {
                leftMax = Math.max(leftMax, height[left]);
                result += leftMax - height[left];

                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                result += rightMax - height[right];

                right--;
            }
        }

        return result;

    }


}
