package leetCode;

public class PlusOne {
	 public int[] plusOne(int[] digits) {
	        int l=digits.length;
	        for(int i=l-1;i>=0;i--){
	            int temp=digits[i]+1;
	            if(temp<10){
	                digits[i]++;
	                return digits;
	            }
	            else{
	                digits[i]=0;
	            }
	        }
	        
	            int[] result=new int[l+1];
	            result[0]=1;
	        
	        return result;
	    }
}
