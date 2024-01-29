package com.yupi.springbootinit.model.dto.chart;

import com.yupi.springbootinit.manager.openAI;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class openAITest {

    @Resource
    private openAI openAI;
    @Test
    void createChatCompletion() {
        String message = "如何学习java";
        String result = openAI.createChatCompletion(message,"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");
        System.out.println(result);
    }
}