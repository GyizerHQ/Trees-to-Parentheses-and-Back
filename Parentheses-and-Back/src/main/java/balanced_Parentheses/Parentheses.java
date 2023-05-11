package balanced_Parentheses;

import java.util.ArrayList;
import java.util.List;

public abstract class Parentheses {

	public <String> List<String> generateParenthesis(int n)
	{
		List<String> result = new ArrayList();
		findAll("(",1,0,(List<java.lang.String>) result, n);
		return result;
	}
	 void findAll(String current,int o, int c , List<String> result , int n) {
		 
		 if(current.length()==2*n) {
			 result.add(current);
			 return;
		 }
		 if(o<n)findAll(current+"(", o+1, c, result, n);
		 if(c<o)findAll(current+")", o, c+1, result, n);
	 }
}

