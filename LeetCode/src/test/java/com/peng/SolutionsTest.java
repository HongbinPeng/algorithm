package com.peng;

import com.peng.Solutions.LeetCode1161;
import com.peng.Solutions.LeetCode77;
import org.junit.jupiter.api.Test; // JUnit 5的@Test注解（注意包名！）
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// 1. @ExtendWith(SpringExtension.class)：让JUnit5支持Spring功能
// 2. @ContextConfiguration：指定Spring配置类（加载Bean容器）
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class SolutionsTest {
    @Autowired
    private LeetCode1161 leetCode1161; // 注入LeetCode1161实例
    @Test
    public void LeetCode1161(){
        System.out.println(leetCode1161);
    }
    @Autowired
    LeetCode77 leetCode77;
    @Test
    public  void LeetCode77(){
        System.out.println(leetCode77.combine(4,2));

    }
}
