package example.weaver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 *
 */
public class ExampleMain {

    private static final Logger log = LoggerFactory.getLogger(ExampleMain.class);

    public static void main(String[] args) {

        try {
            ListHolder listHolder = new ListHolder(args);

            List<String> list = listHolder.getList();

            log.info("{}", list);

            log.info(listHolder.toString());
        } catch (Exception e) {
            log.error("Unexpected Exception:", e);
        }

    }

}
