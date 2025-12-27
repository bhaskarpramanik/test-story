package io.github.bhaskarpramanik.automation.screenplay.actions;

import io.github.bhaskarpramanik.automation.screenplay.capabilities.Capability;

@FunctionalInterface
public interface UsingCapability {
  <T extends Capability> T usingCapabilityTo(Class<? extends T> doSomething);
}
