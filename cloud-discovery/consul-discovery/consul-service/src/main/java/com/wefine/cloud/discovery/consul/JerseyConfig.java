package com.wefine.cloud.discovery.consul;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/rest")
public class JerseyConfig extends ResourceConfig {

  public JerseyConfig() {
    register(Endpoint.class);
  }
}
