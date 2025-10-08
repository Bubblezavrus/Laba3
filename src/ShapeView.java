public class ShapeView {
    public void showShapes(Shape[] shapes) {
        for (Shape s: shapes) {
            System.out.println(s);
        }
    }
    public void showTotalArea(double total) {
        System.out.println("\nЗагальна площина всіх фігур:");
    }
    public void showArea(String type, double total) {
        System.out.println("Загальна площина фігури:" + type + total);
    }
}
