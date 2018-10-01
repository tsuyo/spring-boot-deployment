package com.github.tsuyo.springbootdeployment;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Data
@Configuration
@ConfigurationProperties(prefix = "quest")
public class QuestProperties {
  @Data
  public static class Player {
    private String name;
    private int level;
  }

  private String title;
  private List<Player> players;
  private Map<String, String> props;
}
