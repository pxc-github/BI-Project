package com.yupi.springbootinit.manager;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import com.yupi.springbootinit.common.ErrorCode;
import com.yupi.springbootinit.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

//@Service
public class openAI {

    /**
     * AI 对话（需要自己创建请求响应对象）
     * @param openAiApiKey
     * @return
     */

    public String createChatCompletion(String message, String openAiApiKey) {
        if (StringUtils.isBlank(openAiApiKey)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "未传 openAiApiKey");
        }
        String url = "https://api.openai.com/v1/chat/completions";

        String json = JSONUtil.toJsonStr(message);
        String result = HttpRequest.post(url)
                .header("Authorization", "Bearer " + openAiApiKey)
                .body(json)
                .execute()
                .body();
        return result.toString();
    }
}
