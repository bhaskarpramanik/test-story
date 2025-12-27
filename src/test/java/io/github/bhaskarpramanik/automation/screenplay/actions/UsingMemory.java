package io.github.bhaskarpramanik.automation.screenplay.actions;

import io.github.bhaskarpramanik.automation.screenplay.capabilities.Capability;

@FunctionalInterface
public interface UsingMemory {
  <T extends Capability> T usingItsMemory();
}
