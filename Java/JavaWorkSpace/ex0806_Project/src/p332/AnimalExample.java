package p332;

public class AnimalExample {

	public static void main(String[] args) {
		Dog dog = new Dog();
		Cat cat = new Cat();

		dog.sound();
		cat.sound();
		System.out.println("--------");// 자식객체를 생성해서 sound메소드 호출하기

		Animal animal = null;
		animal = new Cat();
		animal.sound();

		animal = new Dog();
		animal.sound();
		System.out.println("--------");// DOG와 CAT을 Animal로 타입을 변환해서 호출하기

		animalSound(new Dog());
		animalSound(new Cat());
	}

	public static void animalSound(Animal animal) {
		animal.sound();//부모타입의 매개변수에 자식객체를 대입해서 메소드의 다형성을 적용
	}

}
