package com.server.server.models.listener;

import java.time.LocalDateTime;

public interface Iauditable {
  void setCreated(LocalDateTime created);

  void setUpdated(LocalDateTime updated);
}
