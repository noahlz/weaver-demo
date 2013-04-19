package example.instrument;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.instrument.Instrumentation;

/**
 * Example java agent.
 * See: http://download.oracle.com/javase/6/docs/api/java/lang/instrument/package-summary.html
 */
public class MyJavaAgent {

    private static final Logger log = LoggerFactory.getLogger(MyJavaAgent.class);

    public static void premain(String args, Instrumentation instrumentation) {
        log.info("in premain()");
        instrumentation.addTransformer(new MyClassFileTransformer());
    }

}

