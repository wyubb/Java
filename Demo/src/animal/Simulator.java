package animal;

public class Simulator {
	public void playSound(Animal animal){
		if(animal instanceof Dog) {
			Dog dog = new Dog();
			dog.cry();
			dog.getAnimalName();
		}else if(animal instanceof Cat) {
			Cat cat = new Cat();
			cat.cry();
			cat.getAnimalName();
		}
		
	}
}
