package org.fabianlee.springbootwithdockerpush.user;

import org.fabianlee.springbootwithdockerpush.user.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class UserHealthIndicator implements HealthIndicator {

  @Autowired
  protected UserController userController;

  @Override
  public Health health() {
    int userCount = ((Number)userController.fetchUserCount().get()).intValue();
    if (userCount>0)
      return new Health.Builder().up().withDetail("usercount", userCount).build();
    else
      return new Health.Builder().down().withDetail("usercount", userCount).build();
  }

}
