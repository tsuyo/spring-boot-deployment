package com.github.tsuyo.springbootdeployment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@Slf4j
public class SpringBootDeploymentApplication {
  @Autowired private QuestProperties props;

  public static void main(String[] args) {
    SpringApplication.run(SpringBootDeploymentApplication.class, args);
  }

  @EventListener(ApplicationReadyEvent.class)
  public void ready() {
    log.info("title: " + props.getTitle());
    props
        .getPlayers()
        .forEach(
            player -> {
              log.info("player: " + player);
            });
    props
        .getProps()
        .forEach(
            (k, v) -> {
              log.info("prop: " + k + "=" + v);
            });
  }
}
