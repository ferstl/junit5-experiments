package com.github.ferstl.junit5experiments.spring;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(SpringTest.TestConfig.class)
class SpringTest {

  @Autowired
  @RegisterExtension
  SpringExtension springExtension;

  @Test
  void test() {
  }

  @Configuration
  static class TestConfig {

    @Bean
    NameProvider nameProvider() {
      return () -> "test Name";
    }

    @Bean
    SpringExtension springExtension(NameProvider nameProvider) {
      return new SpringExtension(nameProvider);
    }
  }
}
