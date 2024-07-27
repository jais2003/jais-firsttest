// Licensed to the Software Freedom Conservancy (SFC) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The SFC licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.internal.Require;
import org.openqa.selenium.support.ui.Sleeper;
/**
 * This is to demonstrate  what until function in FluentWait is implemented.
 * What does the parameters under <> mean and how they are used.
 */



/**
 * An implementation of the {@link Wait} interface that may have its timeout and polling interval
 * configured on the fly.
 *
 * <p>Each FluentWait instance defines the maximum amount of time to wait for a condition, as well
 * as the frequency with which to check the condition. Furthermore, the user may configure the wait
 * to ignore specific types of exceptions whilst waiting, such as {@link
 * org.openqa.selenium.NoSuchElementException NoSuchElementExceptions} when searching for an element
 * on the page.
 *
 * <p>Sample usage:
 *
 * <pre>
 *   // Waiting 30 seconds for an element to be present on the page, checking
 *   // for its presence once every 5 seconds.
 *   Wait&lt;WebDriver&gt; wait = new FluentWait&lt;WebDriver&gt;(driver)
 *       .withTimeout(Duration.ofSeconds(30L))
 *       .pollingEvery(Duration.ofSeconds(5L))
 *       .ignoring(NoSuchElementException.class);
 *
 *   WebElement foo = wait.until(new Function&lt;WebDriver, WebElement&gt;() {
 *     public WebElement apply(WebDriver driver) {
 *       return driver.findElement(By.id("foo"));
 *     }
 *   });
 * </pre>
 *
 * <p><em>This class makes no thread safety guarantees.</em>
 *
 * @param <T> The input type for each condition used with this instance.
 */
public class FluentWaity<T> implements Waity<T> {

  private final T input = null;
  protected static final long DEFAULT_SLEEP_TIMEOUT = 500;

  private static final Duration DEFAULT_WAIT_DURATION = Duration.ofMillis(DEFAULT_SLEEP_TIMEOUT);


  private final Sleeper sleeper = null;

  private Duration timeout = DEFAULT_WAIT_DURATION;
  private Duration interval = DEFAULT_WAIT_DURATION;
  private Supplier<String> messageSupplier = () -> null;

  private final List<Class<? extends Throwable>> ignoredExceptions = new ArrayList<>();

  /**
   * Repeatedly applies this instance's input value to the given function until one of the following
   * occurs:
   *
   * <ol>
   *   <li>the function returns neither null nor false
   *   <li>the function throws an unignored exception
   *   <li>the timeout expires
   *   <li>the current thread is interrupted
   * </ol>
   *
   * @param isTrue the parameter to pass to the {@link ExpectedCondition}
   * @param <V> The function's expected return type.
   * @return The function's return value if the function returned something different from null or
   *     false before the timeout expired.
 * @throws Exception 
   * @throws TimeoutException If the timeout expires.
   */
  @Override
  public <V> V untily(Function<? super T, V> isTrue) throws Exception {
    Clock clock = null;
	Instant end = clock.instant().plus(timeout);

    Throwable lastException;
    while (true) {
      try {
        V value = isTrue.apply(input);
        if (value != null && (Boolean.class != value.getClass() || Boolean.TRUE.equals(value))) {
          return value;
        }

        // Clear the last exception; if another retry or timeout exception would
        // be caused by a false or null value, the last exception is not the
        // cause of the timeout.
        lastException = null;
      } catch (Throwable e) {
        lastException = propagateIfNotIgnored(e);
      }

      // Check the timeout after evaluating the function to ensure conditions
      // with a zero timeout can succeed.
      if (end.isBefore(clock.instant())) {
        String message = messageSupplier != null ? messageSupplier.get() : null;

        String timeoutMessage =
            String.format(
                "Expected condition failed: %s (tried for %d second(s) with %d milliseconds"
                    + " interval)",
                message == null ? "waiting for " + isTrue : message,
                timeout.getSeconds(),
                interval.toMillis());
        throw timeoutException(timeoutMessage, lastException);
      }

      try {
        sleeper.sleep(interval);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new WebDriverException(e);
      }
    }
  }

private Exception timeoutException(String timeoutMessage, Throwable lastException) {
	// TODO Auto-generated method stub
	return null;
}

private Throwable propagateIfNotIgnored(Throwable e) {
	// TODO Auto-generated method stub
	return null;
}
}
