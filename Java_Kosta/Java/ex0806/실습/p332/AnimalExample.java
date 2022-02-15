package p332;

public class AnimalExample {

	public static void main(String[] args) {
		Dog dog = new Dog();
		Cat cat = new Cat();

		dog.sound();
		cat.sound();
		System.out.println("--------");// �ڽİ�ü�� �����ؼ� sound�޼ҵ� ȣ���ϱ�

		Animal animal = null;
		animal = new Cat();
		animal.sound();

		animal = new Dog();
		animal.sound();
		System.out.println("--------");// DOG�� CAT�� Animal�� Ÿ���� ��ȯ�ؼ� ȣ���ϱ�

		animalSound(new Dog());
		animalSound(new Cat());
	}

	public static void animalSound(Animal animal) {
		animal.sound();//�θ�Ÿ���� �Ű������� �ڽİ�ü�� �����ؼ� �޼ҵ��� �������� ����
	}

}
