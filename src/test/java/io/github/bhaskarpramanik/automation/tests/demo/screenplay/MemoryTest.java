package io.github.bhaskarpramanik.automation.tests.demo.screenplay;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.LIST;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.github.bhaskarpramanik.automation.screenplay.Actor;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@SuppressWarnings("all")
class MemoryTest {

  private final Actor user;

  {
    this.user = new Actor();
  }

  @BeforeEach
  void resetMemoryBeforeEachTest() {
    this.user.usingItsMemory().forgetAll();
  }

  @Test
  void memoryHoldsCollectionOfObjects() {
    user.usingItsMemory()
        .remembersThat("key")
        .stores(List.of("some-other-value", "some-value", "a-different-value"));

    var value = user.usingItsMemory().recallsValueOf("key");

    assertThat(value)
        .asInstanceOf(LIST)
        .contains("some-other-value")
        .isEqualTo(List.of("some-other-value", "some-value", "a-different-value"));
  }

  @Test
  void memoryHoldsStringObjects() {
    user.usingItsMemory().remembersThat("key").stores("some-value");
    assertThat(user.usingItsMemory().recallsValueOf("key")).isEqualTo("some-value");
  }

  @Test
  void memoryHoldsIntegerObjects() {
    user.usingItsMemory().remembersThat("key").stores(1);
    assertThat(user.usingItsMemory().recallsValueOf("key")).isEqualTo(1);
  }

  @Test
  void memoryHoldsBooleanObjects() {
    user.usingItsMemory().remembersThat("key").stores(true);
    assertThat(user.usingItsMemory().recallsValueOf("key")).isEqualTo(true);
  }

  @Test
  void storingNullValueThrowsException() {
    IllegalArgumentException ex =
        assertThrows(
            IllegalArgumentException.class,
            () -> user.usingItsMemory().remembersThat(null).stores(null));
    assertThat(ex.getMessage()).isEqualTo("Memory key or value can not be null.");
  }

  @Test
  void actorCanRemembersManyObjectsAtOnce() {
    user.usingItsMemory().remembersAll(Map.of("first", "1", "second", 2, "third", true));
    var recalledFirstValue = user.usingItsMemory().recallsValueOf("first");
    var recalledSecondValue = user.usingItsMemory().recallsValueOf("second");
    var recalledthirdValue = user.usingItsMemory().recallsValueOf("third");

    assertThat(recalledFirstValue).isEqualTo("1");
    assertThat(recalledSecondValue).isEqualTo(2);
    assertThat(recalledthirdValue).isEqualTo(true);
  }

  @Test
  void actorCanForgetsSpecificMemoryItem() {
    user.usingItsMemory().remembersAll(Map.of("first", 1, "second", 2));

    assertThat(user.usingItsMemory().countsMemorizedObjects()).isEqualTo(2);

    // forgets first
    user.usingItsMemory().forgetsValueOf("first");
    assertThat(user.usingItsMemory().countsMemorizedObjects()).isEqualTo(1);

    assertThrows(NullPointerException.class, () -> user.usingItsMemory().recallsValueOf("first"));
  }

  @Test
  void actorCanForgetAll() {
    user.usingItsMemory().remembersAll(Map.of("first", 1, "second", 2));
    assertThat(user.usingItsMemory().countsMemorizedObjects()).isEqualTo(2);

    // forgets all
    user.usingItsMemory().forgetAll();
    assertThat(user.usingItsMemory().countsMemorizedObjects()).isZero();
  }
}
