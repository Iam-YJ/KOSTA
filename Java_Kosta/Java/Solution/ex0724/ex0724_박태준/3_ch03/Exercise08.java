class Exercise08
{
	public static void main(String [] args)
	{

		//NaN => Not a Number
		double x = 5.0;
		double y = 0.0;

		double z = x%y;
		//System.out.println("Double.valueOf(z) = " + Double.valueOf(z));

		if (Double.isNaN(z)) //true��� ���ڰ� �ƴϴ�.
		{
			System.out.println("0.0���� ���� �� �����ϴ�.");	
		} 
		else {
			double result = z + 10;
			System.out.println("��� : " + result);
		}

	}
}