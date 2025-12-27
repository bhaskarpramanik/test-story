package io.github.bhaskarpramanik.automation.screenplay;

import io.github.bhaskarpramanik.automation.screenplay.abilities.Memorize;
import io.github.bhaskarpramanik.automation.screenplay.actions.UsingCapability;
import io.github.bhaskarpramanik.automation.screenplay.actions.UsingMemory;
import io.github.bhaskarpramanik.automation.screenplay.capabilities.Capability;
import io.github.bhaskarpramanik.automation.screenplay.exceptions.NoSuchAbilityException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

@SuppressWarnings("all")
public class Actor implements UsingCapability, UsingMemory {

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
}
