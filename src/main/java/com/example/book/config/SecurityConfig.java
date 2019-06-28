package com.example.book.config;

import com.example.book.BookPermissionEvaluator;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends GlobalMethodSecurityConfiguration {

  private final BookPermissionEvaluator permissionEvaluator;

  public SecurityConfig(BookPermissionEvaluator permissionEvaluator) {
    this.permissionEvaluator = permissionEvaluator;
  }

  @Override
  protected MethodSecurityExpressionHandler createExpressionHandler() {
    DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();
    expressionHandler.setPermissionEvaluator(permissionEvaluator);
    return expressionHandler;
  }
}
