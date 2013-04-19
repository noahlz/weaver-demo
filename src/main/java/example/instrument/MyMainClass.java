package example.instrument;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class MyMainClass {

    private static final Logger log = LoggerFactory.getLogger(MyMainClass.class);

    private final String data;

    MyMainClass(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "MyMainClass{" +
                "data='" + data + '\'' +
                '}';
    }

    public static void main(String[] args) {

        log.info(new MyMainClass("Some data.").toString());

    }


}
