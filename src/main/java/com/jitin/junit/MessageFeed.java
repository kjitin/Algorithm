package com.jitin.junit;

import java.util.List;

public class MessageFeed {

  private String messageId;
  private String operation;
  private Type type;
  private Long timestamp;

  private List<String> data;

  public MessageFeed(String messageId, String operation, Type type, Long timestamp, List<String> data) {
    this.messageId = messageId;
    this.operation = operation;
    this.type = type;
    this.timestamp = timestamp;
    this.data = data;
  }
}
