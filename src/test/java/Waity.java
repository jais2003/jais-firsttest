import java.util.function.Function;
import org.openqa.selenium.support.ui.ExpectedCondition;

public interface Waity<F> {

	  /**
	   * Implementations should wait until the condition evaluates to a value that is neither null nor
	   * false. Because of this contract, the return type must not be Void.
	   *
	   * <p>If the condition does not become true within a certain time (as defined by the implementing
	   * class), this method will throw a non-specified {@link Throwable}. This is so that an
	   * implementor may throw whatever is idiomatic for a given test infrastructure (e.g. JUnit4 would
	   * throw {@link AssertionError}).
	   *
	   * @param <T> the return type of the method, which must not be Void
	   * @param isTrue the parameter to pass to the {@link ExpectedCondition}
	   * @return truthy value from the isTrue condition
	 * @throws Exception 
	   */
	  <T> T untily(Function<? super F, T> isTrue) throws Exception;
}