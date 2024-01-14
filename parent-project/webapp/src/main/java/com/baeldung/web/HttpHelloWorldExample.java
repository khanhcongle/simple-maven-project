package com.baeldung.web;

import static io.activej.http.HttpMethod.POST;

import java.util.concurrent.Executor;

import io.activej.http.AsyncServlet;
import io.activej.http.HttpResponse;
import io.activej.http.RoutingServlet;
import io.activej.http.StaticServlet;
import io.activej.http.loader.IStaticLoader;
import io.activej.inject.Injector;
import io.activej.inject.annotation.Provides;
import io.activej.launcher.Launcher;
import io.activej.launchers.http.HttpServerLauncher;
import io.activej.reactor.Reactor;
import io.activej.http.HttpMethod;

public final class HttpHelloWorldExample extends HttpServerLauncher {
  private static final String RESOURCE_DIR = "static/query";

  Injector injector = Injector.of(new ConfigModule(), new ServiceModule());

  @Provides
  IStaticLoader staticLoader(Reactor reactor, Executor executor) {
    return IStaticLoader.ofClassPath(reactor, executor, RESOURCE_DIR);
  }

  @Provides
  AsyncServlet servlet(Reactor reactor, IStaticLoader staticLoader) {
    return RoutingServlet.builder(reactor)
        .with(POST, "/hello", request -> request.loadBody()
            .then($ -> {
              String name = request.getPostParameters().get("name");
              return HttpResponse.ok200()
                  .withHtml("<h1><center>Hello from POST, " + name + "!</center></h1>")
                  .toPromise();
            }))
        .with(HttpMethod.GET, "/hello", request -> {
          String name = request.getQueryParameter("name");
          return HttpResponse.ok200()
              .withHtml("<h1><center>Hello from GET, " + name + "!</center></h1>")
              .toPromise();
        })
        .with("/*", StaticServlet.builder(reactor, staticLoader)
            .withIndexHtml()
            .build())
        .build();
  }

  public static void main(String[] args) throws Exception {
    Launcher launcher = new HttpHelloWorldExample();
    launcher.launch(args);
  }
}
