package com.hce.config;

import com.hce.interceptor.AuditInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 初使化Mybatis审计字段自动赋值的interceptor
 */
@Configuration
@ComponentScan(basePackageClasses = AuditInterceptor.class)
public class MybatisConfig {
}
