package com.github.ferstl.junit5experiments;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

@ExtendWith(TestLifecycle.TestExtension.class)
class TestLifecycle {

  @BeforeAll
  static void beforeAll() {
    System.out.println("withinBeforeAll");
  }

  @AfterAll
  static void afterAll() {
    System.out.println("withinAfterAll");
  }

  @BeforeEach
  void beforeEach() {
    System.out.println("within beforeEeach");
  }

  @AfterEach
  void afterEach() {
    System.out.println("within afterEach");
  }

  @Test
  void test1() {
    System.out.println("within test 1");
  }

  @Test
  void test2() {
    System.out.println("within test 2");
  }

  static class TestExtension implements BeforeAllCallback, AfterAllCallback, BeforeEachCallback, AfterEachCallback, BeforeTestExecutionCallback, AfterTestExecutionCallback, TestInstancePostProcessor {

    @Override
    public void afterAll(ExtensionContext context) {
      System.out.println("withinAfterAllCallback");
    }

    @Override
    public void afterEach(ExtensionContext context) {
      System.out.println("withinAfterEachCallback");
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
      System.out.println("withinAfterTestExecutionCallback");
    }

    @Override
    public void beforeAll(ExtensionContext context) {
      System.out.println("withinBeforeAllCallback");
    }

    @Override
    public void beforeEach(ExtensionContext context) {
      System.out.println("withinBeforeEachCallback");
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) {
      System.out.println("withinBeforeTestExecutionCallback");
    }

    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {
      System.out.println("within postProcessTestInstance");
    }
  }
}

