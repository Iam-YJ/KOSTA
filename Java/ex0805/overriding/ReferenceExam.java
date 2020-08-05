class ObjectExam{
	String str;

	public ObjectExam(){   }

	public ObjectExam(String str){
		this.str = str;
	}
	
	public String toString(){
		return str +" 주소: " +  super.toString();
	} //오버라이딩 해서 주소값이 아닌 출력이 나오게 한다.

	//재정의 @Overriding ... Annotation : 표식

}
class ReferenceExam{
	public static void main(String[] args){
			char c='a';
			String s01="장희정"; 
			String s02="Java";
			String s03=new String("월요일");
			ObjectExam oe1=new ObjectExam("좋다");
			ObjectExam oe2=new ObjectExam("안녕");

			
			System.out.println(c);//
			/* 
			print(Object obj) or println(Object obj)는 인수로 Object를 받으먼
			자동으로 Object에 정의되어 있는 toString() 메소드가 호출된다.

			:Object에 정의된 toString()는 메소드는 객체의 주소를 String의 문자열로 만들어 리턴한다.
			 ex) 클래스이름 @hashcode 형태로 리턴한다.
			*/

			System.out.println(s01);
			//System.out.println(s01.toString()); 과 같다 
			//주소값을 찍지 않고 문자열을 찍는 이유 
			// -> String이 Object에 정의되어 있는 toString() 재정의 해서 다른 일을 한다 .
			System.out.println(s02);//
			System.out.println(s03);//
			System.out.println(oe1);//
			System.out.println(oe2);//
			
	}
}
