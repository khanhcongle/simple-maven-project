package com.baeldung.web;

import com.baeldung.core.DataSource;
import com.baeldung.core.Service;

import io.activej.inject.annotation.Provides;
import io.activej.inject.module.AbstractModule;

public class ServiceModule extends AbstractModule {

  @Provides
  Service service(DataSource dataSource) {
    return new Service(dataSource);
  }
  
}