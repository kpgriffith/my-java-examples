package kpgriffith.examples.patterns.abstractfactory;

public class AnimalFactory implements AbstractFactory<Animal> {

  @Override
  public Animal create(String animalType) {
    if ("Dog".equals(animalType)) {
      return new Dog();
    } else if ("Duck".equalsIgnoreCase(animalType)) {
      return new Duck();
    }
    return null;
  }
}
