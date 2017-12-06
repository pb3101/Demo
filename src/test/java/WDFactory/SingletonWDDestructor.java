package WDFactory;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by pavlo.balyuk on 12/4/2017.
 */
public class SingletonWDDestructor {

    public void SingletonWDDestructor(String browser) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {
    /* You can use a relative path, the same package can not take packet path */
        Class s = Class.forName("WDFactory.SingletonWD");
        Constructor ct = s.getDeclaredConstructor();

        /* true: The Java does not check the access restrictions, or you can use the private method */
        ct.setAccessible(true);

        System.out.println(SingletonWD.getInstance(browser));

        System.out.println(ct.newInstance(browser));

        System.out.println(SingletonWD.getInstance(browser) == ct.newInstance());

    }
}
