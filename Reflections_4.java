import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.AnnotatedElement;

// Define the annotation
@Retention(RetentionPolicy.RUNTIME)
@interface Info {
    String author();
    double version();
}

// Apply the annotation to Library class
@Info(author = "John Doe", version = 1.2)
class Library {
}

public class Reflections_4 {
    public static void main(String[] args) {
        Class<Library> libraryClass = Library.class;

        // Check if annotation exists
        if (libraryClass.isAnnotationPresent(Info.class)) {
            System.out.println("Library class is annotated with @Info");

            // Retrieve annotation values
            Info info = libraryClass.getAnnotation(Info.class);
            System.out.println("Author: " + info.author());
            System.out.println("Version: " + info.version());
        } else {
            System.out.println("Library class is not annotated with @Info");
        }
    }
}