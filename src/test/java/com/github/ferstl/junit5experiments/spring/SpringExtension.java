package com.github.ferstl.junit5experiments.spring;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class SpringExtension implements BeforeEachCallback {

  private final NameProvider nameProvider;

  public SpringExtension(NameProvider nameProvider) {
    this.nameProvider = nameProvider;
  }

  @Override
  public void beforeEach(ExtensionContext context) throws Exception {
    System.out.println("Name: " + this.nameProvider.getName());
  }
}
