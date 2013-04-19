package example.instrument;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 *
 */
public class MyClassFileTransformer implements ClassFileTransformer {

    private static final Logger log = LoggerFactory.getLogger(MyClassFileTransformer.class);

    public byte[] transform(final ClassLoader loader,
                            final String className,
                            final Class<?> classBeingRedefined,
                            final ProtectionDomain protectionDomain,
                            final byte[] classFileBuffer) throws IllegalClassFormatException {

        log.info("Got to MyClassFileTransformer.transform()");
        log.info("Class Name: {}", className);
        log.info("Class: {}", classBeingRedefined);
        log.info("************ RAW CLASS BYTES ************");
        log.info("{}", byteArrayToHexString(classFileBuffer));
        log.info("*****************************************");

        return classFileBuffer;
    }

    private static String byteArrayToHexString(byte [] classBytes) {
        final StringBuilder buff = new StringBuilder();
        for (byte classByte : classBytes) {
            buff.append(Integer.toHexString(classByte));
        }
        return buff.toString();
    }
}
