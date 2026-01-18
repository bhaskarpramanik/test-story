package io.github.bhaskarpramanik.automation.screenplay.capabilities;

import io.github.bhaskarpramanik.automation.screenplay.Actor;

@FunctionalInterface
public interface Query<T> {
  // Represents queries made to obtain the state of a system
  // e.g. Http actions like GET, HEAD etc.
  T by(Actor actor);
}
