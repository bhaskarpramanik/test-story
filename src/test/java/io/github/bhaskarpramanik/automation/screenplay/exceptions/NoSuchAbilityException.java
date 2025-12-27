package io.github.bhaskarpramanik.automation.screenplay.exceptions;

public class NoSuchAbilityException extends RuntimeException {
  public <T> NoSuchAbilityException(Class<T> ability) {
    super(String.format("Actor doesn't have ability [%s] ", ability.getName()));
  }
}
