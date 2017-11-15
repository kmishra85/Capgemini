
public class Main {
	
	
	
	public static void fun(int ...a)
	{
		for(int out:a)
		{
			System.out.println(out+"\n");
		}
	}
	
	public static void func(int a,String ...c)
	{
		System.out.println(a);
		for(String o:c)
		{
			System.out.println(o);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		fun(100);
		fun(10,20,30);
		func(10,"10","70","80","90");
	}

}
