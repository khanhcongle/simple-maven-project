package com.baeldung.web;

import java.net.InetSocketAddress;

import io.activej.inject.annotation.Provides;
import io.activej.inject.module.AbstractModule;

public class ConfigModule extends AbstractModule {

  @Provides
  InetSocketAddress inetSocketAddress() {
    return new InetSocketAddress(1234);
  }

  @Provides
  String dbName() {
    return "exampleDB";
  }
}
