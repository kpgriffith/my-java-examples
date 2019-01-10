package kpgriffith.examples.patterns.abstractfactory;

public class ColorFactory implements AbstractFactory<Color> {

  @Override
  public Color create(String colorType) {
    if("White".equalsIgnoreCase(colorType)) {
      return new White();
    } else if("Brown".equalsIgnoreCase(colorType)) {
      return new Brown();
    }
    return null;
  }
}
