package com.baeldung.core;

import io.activej.inject.annotation.Inject;

public class Service {
  private final DataSource dataSource;

  @Inject
  public Service(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public void process() {
    String data = dataSource.queryData();
    System.out.printf("Processing data: '%s'%n", data);
  }
}
