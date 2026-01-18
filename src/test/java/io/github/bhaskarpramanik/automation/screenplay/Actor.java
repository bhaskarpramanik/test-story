package io.github.bhaskarpramanik.automation.screenplay;

import io.github.bhaskarpramanik.automation.screenplay.abilities.Memorize;
import io.github.bhaskarpramanik.automation.screenplay.actions.*;
import io.github.bhaskarpramanik.automation.screenplay.capabilities.*;
import io.github.bhaskarpramanik.automation.screenplay.exceptions.NoSuchAbilityException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import org.apache.commons.lang3.function.Failable;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ObjectAssert;

@SuppressWarnings("all")
public class Actor implements UsingCapability, UsingMemory, Action, Asserts {

  private final Map<Class, Capability> capabilities;

  // actor always has a memory by default
  public Actor() {
    this(new Memorize());
  }

  public Actor(Capability... capabilities) {
    this.capabilities = new HashMap<>();
    Stream.of(capabilities)
        .forEach(capability -> this.capabilities.put(capability.getClass(), capability));
  }

  @Override
  public <T extends Capability> T usingCapabilityTo(Class<? extends T> doSomething) {
    return (T)
        Optional.of(capabilities.get(doSomething))
            .orElseThrow(() -> new NoSuchAbilityException(doSomething));
  }

  public Memorize usingItsMemory() {
    return this.usingCapabilityTo(Memorize.class);
  }

  @Override
  public <T> T queries(Query<T> query) {
    return query.by(this);
  }

  @Override
  public void directs(Command... commands) {
    Failable.stream(Arrays.asList(commands)).forEach(command -> command.as(this));
  }

  @Override
  public <T> ObjectAssert<T> assertsThat(Query<T> query) {
    return Assertions.assertThat(query.by(this));
  }
}
