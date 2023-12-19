package demo1;

public class Test {

	public static void main(String[] args) {
		/**
		 * C O M P U T E R 
		   O              E
		   M              T
	       P              U
		   U              P
		   T              M
	       E              O
	       R  E T U P M O C 
		 */
		String s ="COMPUTER";
		for(int i=0;i<s.length();i++)
		{
			if(i==0) 
				System.out.print(s);
			else {
				if(i==s.length()-1)
					for(int s1=i;s1>=0;s1--)
						System.out.print(s.charAt(s1));
				else {
					System.out.print(s.charAt(i));
					for(int k=0;k<s.length()-2;k++)
					{
						System.out.print(" ");
					}

					System.out.print(s.charAt(s.length()-1-i));
				}
			}

			System.out.println();

		}


	}

}
