package leetCode;

public class 	AddBinary {
	public String addBinary(String a, String b) {
		if(a==null)return b;
		if(b==null)return a;
		StringBuffer sb = new StringBuffer();
		int i = a.length() - 1, j = b.length() - 1, flag = 0, sum = 0;
		while (i >= 0 || j >= 0) {
			if (i < 0) {
				sum = (b.charAt(j) - '0') + flag;
				j--;
			} else if (j < 0) {
				sum = (a.charAt(i) - '0') + flag;
				i--;
			} else{
				sum = (a.charAt(i) - '0') + (b.charAt(j) - '0') + flag;
				i--;j--;}
			if (sum % 2 == 0) {
				sb.append("0");
			}
			if (sum % 2 == 1) {
				sb.append("1");
			}
			if (sum / 2 == 1)
				flag = 1;
			else
				flag = 0;

		}
		if(flag==1)sb.append("1");
		return sb.reverse().toString();
	}
}
