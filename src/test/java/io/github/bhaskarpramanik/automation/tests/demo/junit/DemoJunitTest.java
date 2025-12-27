package io.github.bhaskarpramanik.automation.tests.demo.junit;

import io.github.bhaskarpramanik.automation.base.config.junit.JunitConfiguration;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@JunitConfiguration
class DemoJunitTest {

  @Test
  void demoTest() {
    // dummy junit test
    Assertions.assertThat(true).isNotNull();
  }
}
