package io.github.bhaskarpramanik.automation.screenplay.capabilities;

import io.github.bhaskarpramanik.automation.screenplay.Actor;

@FunctionalInterface
public interface Command {
  // Represents commands issued to change the state of a system
  // e.g. Http actions like POST, PUT, PATCH, DELETE etc.
  void as(Actor actor);
}
