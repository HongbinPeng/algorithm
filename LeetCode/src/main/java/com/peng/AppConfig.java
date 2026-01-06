package com.peng;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// @Configuration：标记这是Spring配置类
// @ComponentScan：扫描com.peng包下所有带@Component的类（包括Solutions里的题目类）
@Configuration
@ComponentScan("com.peng")
public class AppConfig {
}