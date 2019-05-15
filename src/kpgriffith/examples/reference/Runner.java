package kpgriffith.examples.reference;

public class Runner {

  private final Other other;
  private final Model model;

  public Runner(){
    model = new Model();
    other = new Other();
  }

  public void testRefOrValue(){
    model.setName("Kevin");
    System.out.println("testRefOrValue: Model before is: " + model);
    other.otherMethod(model);
    System.out.println("testRefOrValue: Model after is: " + model);
  }

}
