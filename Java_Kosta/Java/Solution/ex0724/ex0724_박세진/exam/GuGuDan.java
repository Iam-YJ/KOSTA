public class GuGuDan
{
	public static void main(String[] args)
	{
		System.out.println("1. 2�� for���� �̿��ؼ� �������� ���(9�� 8��)");
		/*
		    2 * 1 = 2	3*1=3	4*1=4 ...	9*1=9
			2 * 2 = 4	3*2=6
			2 * 3 = 6
			...
			2 * 9 = 18
		*/
		for (int y = 1;y < 10;y++)
		{
			for (int x = 2;x < 10;x++)
				System.out.print(x + "x" + y + "=" + y*x + "\t");
			System.out.println();
		}
	}
}