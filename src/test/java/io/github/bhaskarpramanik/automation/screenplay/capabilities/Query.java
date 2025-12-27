package io.github.bhaskarpramanik.automation.screenplay.capabilities;

import io.github.bhaskarpramanik.automation.screenplay.Actor;

@FunctionalInterface
public interface Query<T> {
  //  A query that can be made by the actor to the system
  T by(Actor actor);
}
