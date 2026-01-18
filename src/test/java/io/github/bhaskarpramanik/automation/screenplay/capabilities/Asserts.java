package io.github.bhaskarpramanik.automation.screenplay.capabilities;

import org.assertj.core.api.ObjectAssert;

public interface Asserts {
  <T> ObjectAssert<T> assertsThat(Query<T> query);
}
