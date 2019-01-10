package kpgriffith.examples.patterns.abstractfactory;

public interface AbstractFactory<T> {

  T create(String type);

}
