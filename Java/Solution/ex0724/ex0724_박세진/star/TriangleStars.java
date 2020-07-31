public class TriangleStars
{
	public static void main(String[] args)
	{
		// #1
		for (int i = 0;i < 5;i++)
		{
			for (int j = 0;i-j >= 0;j++)
				System.out.print("¡Ú\t");
			System.out.println();
		}
		System.out.println("------------------------------------------------------");
		// #2
		for (int i = 0;i < 5;i++)
		{
			for (int j = 5;j-i > 0;j--)
				System.out.print("¡Ú\t");
			System.out.println();
		}
		System.out.println("------------------------------------------------------");
		// #3
		for (int i = 5;i > 0;i--)
		{
			for (int j = 0;i-j >= 0;j++)
			{
				if (j > 0) System.out.print("\t");
				if (i-j == 1)
				{
					for (int n = 5-j;n > 0;n--)
						System.out.print("¡Ú\t");
				}
			}
			System.out.println();
		}
		System.out.println("------------------------------------------------------");
		// #4
		for (int i = 0;i < 5;i++)
		{
			for (int j = 0;i-j >= 0;j++)
			{
				if (j > 0) System.out.print("\t");
				if (i-j == 0)
				{
					for (int n = 5-i;n > 0;n--)
						System.out.print("¡Ú\t");
				}
			}
			System.out.println();
		}
	}
}