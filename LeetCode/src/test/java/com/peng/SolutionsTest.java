package com.peng;

import com.peng.Solutions.LeetCode1161;
import com.peng.Solutions.LeetCode199;
import com.peng.Solutions.LeetCode33;
import com.peng.Solutions.LeetCode77;
import com.peng.utils.TreeNode;
import org.junit.jupiter.api.Test; // JUnit 5的@Test注解（注意包名！）
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

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
    @Autowired
    LeetCode33 leetCode33;
    @Test
    public void LeetCode33(){
        LeetCode33.Solution s=new LeetCode33.Solution();
        System.out.println(s.search(new int[]{4,5,6,7,0,1,2},0));
    }
    @Autowired
    LeetCode199 leetCode199;
    @Test
    public void LeetCode199(){
        int[] inorder=new int[]{2,5,1,3,4};
        int [] preorder=new int[]{1,2,5,3,4};
        int [] postorder=new int[]{5,2,4,3,1};
        TreeNode treeNode = TreeNode.builder().buildTreeFromInorderAndPreOrder(inorder, preorder);
        List<Integer> integers = leetCode199.rightSideView(treeNode);
        System.out.println(integers);
        treeNode = TreeNode.builder().buildTreeFromInorderAndPostOrder(inorder, postorder);
        integers = leetCode199.rightSideView(treeNode);
        System.out.println(integers);
    }
}
