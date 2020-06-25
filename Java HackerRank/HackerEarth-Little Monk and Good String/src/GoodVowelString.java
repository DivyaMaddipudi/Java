import java.util.*;
	class GoodVowelString
	{
	public static void main(String args[] ) throws Exception
	{
	Scanner s=new Scanner(System.in);
	String str=s.next();
	int i=0,temp_count=0,count=0;
	while(i<str.length())
	{
	if(str.charAt(i)=='a'||str.charAt(i)=='e'||str.charAt(i)=='i'||str.charAt(i)=='o'||str.charAt(i)=='u')
	{
	temp_count++;
	i++;
	while(temp_count!=0&&i<str.length())
	{
	if(str.charAt(i)=='a'||str.charAt(i)=='e'||str.charAt(i)=='i'||str.charAt(i)=='o'||str.charAt(i)=='u')
	{
	temp_count++;
	i++;
	}
	else
	{
	if(count<temp_count)
	count=temp_count;
	temp_count=0;
	
	}
	}

	}
	i++;
	}
	if(temp_count>count)
	count=temp_count;
	System.out.println(count);

	}

	}

