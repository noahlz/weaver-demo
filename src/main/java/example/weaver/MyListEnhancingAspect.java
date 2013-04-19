package example.weaver;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Aspect which targets {@link ListHolder} and sneakily adds an element to the list.
 */
@Aspect
public class MyListEnhancingAspect {

    private static final Logger log = LoggerFactory.getLogger(MyListEnhancingAspect.class);

    @AfterReturning(pointcut = "within(example.weaver.ListHolder) && execution(public java.util.List<String> getList())",
                    returning = "target")
    public void addToList(List<String> target) {
        target.add("Surprise!!! :)");
    }

    @Around("within(example.weaver.ExampleMain) && call(public String example.weaver.ListHolder.toString())")
    public Object replaceListHolderToString(ProceedingJoinPoint joinPoint) throws Throwable {

        String result = (String) joinPoint.proceed();

        log.info("JoinPoint for {} returned value '{}'", joinPoint.toLongString(), result);

        log.info("Throwing java.lang.SecurityException with message \"No toString() for you!\" instead.");

        // we could also return a different result here instead.
        throw new SecurityException("No toString() for you!!! ;)");

    }

}
