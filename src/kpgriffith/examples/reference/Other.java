package kpgriffith.examples.reference;

public class Other {

  public void otherMethod(Model model){
    System.out.println("otherMethod: Model before is: " + model);
//    model = new Model();
    model.setName("New Name");
    System.out.println("otherMethod: Model after is: " + model);
  }

}
