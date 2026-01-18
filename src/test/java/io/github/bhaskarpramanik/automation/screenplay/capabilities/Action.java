package io.github.bhaskarpramanik.automation.screenplay.capabilities;

public interface Action {
  void directs(Command... commands);

  <T> T queries(Query<T> query);
}
