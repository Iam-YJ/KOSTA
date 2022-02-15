class Exercise08
{
	public static void main(String [] args)
	{

		//NaN => Not a Number
		double x = 5.0;
		double y = 0.0;

		double z = x%y;
		//System.out.println("Double.valueOf(z) = " + Double.valueOf(z));

		if (Double.isNaN(z)) //true라면 숫자가 아니다.
		{
			System.out.println("0.0으로 나눌 수 없습니다.");	
		} 
		else {
			double result = z + 10;
			System.out.println("결과 : " + result);
		}

	}
}