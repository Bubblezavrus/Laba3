import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Rectangle("red",4,5),
                new Rectangle("blue",2,3),
                new Triangle("green", 3,6),
                new Triangle("black", 5,10),
                new Circle("purple", 6),
                new Circle("yellow",10),

        };

        ShapeFileManager.saveShapesToFile(shapes, "shapes.dat");

        Shape[] loadedShapes = ShapeFileManager.loadShapesFromFile("shapes.dat");

        ShapeView view = new ShapeView();
        System.out.println("\n--- Фігури, зчитані з файлу ---");
        view.showShapes(loadedShapes);

        double totalArea = 0;
        for (Shape s : shapes) {
            totalArea += s.calcArea();
        }
        view.showTotalArea(totalArea);

        double rectArea = Arrays.stream(shapes)
                .filter(s -> s instanceof Rectangle)
                .mapToDouble(Shape::calcArea).sum();
        view.showArea("Прямокутник", rectArea);

        double triArea = Arrays.stream(shapes)
                .filter(s -> s instanceof Triangle)
                .mapToDouble(Shape::calcArea).sum();
        view.showArea("Трикутник", triArea);

        double circleArea = Arrays.stream(shapes)
                .filter(s -> s instanceof Circle)
                .mapToDouble(Shape::calcArea).sum();
        view.showArea("Коло", circleArea);

        Arrays.sort(shapes, Comparator.comparingDouble(Shape::calcArea));
        System.out.println("\n===Сортування за площею===");
        view.showShapes(shapes);

        Arrays.sort(shapes, Comparator.comparing(Shape::getShapeColor));
        System.out.println("\n===Сортування за кольором===");
        view.showShapes(shapes);
        }
    }
