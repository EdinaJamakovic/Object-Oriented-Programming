package labs.lab10.task1;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface UserPermission {
    String level();
}

