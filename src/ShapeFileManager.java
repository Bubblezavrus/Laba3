import java.io.*;

public class ShapeFileManager {
    public static void saveShapesToFile(Shape[] shapes, String filePath) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(shapes);
            System.out.println("Дані успішно збережено у файл: " + filePath);
        }
        catch (IOException e) {
            System.out.println("Помилка при збережені у файл" + e.getMessage());
        }
    }

    public static Shape [] loadShapesFromFile(String filePath) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            Shape [] shapes = (Shape[]) in.readObject();
            System.out.println("Дані успішно зчитано з файлу" + filePath);
            return shapes;
        }
        catch (IOException | ClassNotFoundException e) {
            System.out.println("Помилка при зчитуванні" + e.getMessage());
            return new Shape[0];
        }
    }
}