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
    System.out.println("within @BeforeAll");
  }

  @AfterAll
  static void afterAll() {
    System.out.println("within @AfterAll");
  }

  @BeforeEach
  void beforeEach() {
    System.out.println("    within @BeforeEach");
  }

  @AfterEach
  void afterEach() {
    System.out.println("    within @AfterEach");
  }

  @Test
  void test1() {
    System.out.println("      within test 1");
  }

  @Test
  void test2() {
    System.out.println("      within test 2");
  }

  static class TestExtension implements BeforeAllCallback, AfterAllCallback, BeforeEachCallback, AfterEachCallback, BeforeTestExecutionCallback, AfterTestExecutionCallback, TestInstancePostProcessor {

    @Override
    public void afterAll(ExtensionContext context) {
      System.out.println("within afterAll() callback");
    }

    @Override
    public void afterEach(ExtensionContext context) {
      System.out.println("    within afterEach() Callback");
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
      System.out.println("      within afterTestExecution() callback");
    }

    @Override
    public void beforeAll(ExtensionContext context) {
      System.out.println("within beforeAll() callback");
    }

    @Override
    public void beforeEach(ExtensionContext context) {
      System.out.println("    within beforeEach() callback");
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) {
      System.out.println("      within beforeTestExecution() callback");
    }

    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {
      System.out.println("    within postProcessTestInstance() callback");
    }
  }
}

