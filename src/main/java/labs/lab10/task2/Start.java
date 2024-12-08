package labs.lab10.task2;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

public class Start {
    public static void main(String[] args) {
        List<Integer> grades = Arrays.asList(85, 90, 78, 92);
        Student student = new Student("Alice", "S12345", grades);

        GradeAnalyser gradeAnalyzer = new GradeAnalyser(grades);

        System.out.println(" Using Reflection on Student Class: ");
        inspectObject(student);

        System.out.println("\n Using reflection on GradeAnalyzer class: ");
        inspectObject(gradeAnalyzer);
    }

    private static void inspectObject(Object obj) {
        Class<?> clazz = obj.getClass();

        System.out.println("Class: " + clazz.getName());

        System.out.println("Fields:");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType().getSimpleName() + " " + field.getName() + " = " + field.get(obj));
            } catch (IllegalAccessException e) {
                System.out.println("Unable to access field: " + field.getName());
            }
        }


        System.out.println("Methods:");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            try {
                if (method.getName().startsWith("calculate") || method.getName().startsWith("print")) {
                    System.out.print("Invoking method: " + method.getName() + " - ");
                    if (method.getReturnType() != void.class) {
                        Object result = method.invoke(obj);
                        System.out.println("Result: " + result);
                    } else {
                        method.invoke(obj);
                        System.out.println("Method executed (void return type).");
                    }
                }
            } catch (Exception e) {
                System.out.println("Error invoking method: " + method.getName());
            }
        }
    }
}

