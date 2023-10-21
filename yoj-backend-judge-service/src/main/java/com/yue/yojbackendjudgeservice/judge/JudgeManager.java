package com.yue.yojbackendjudgeservice.judge;

import com.yue.yojBackendModel.model.codeSandbox.JudgeInfo;
import com.yue.yojBackendModel.model.entity.QuestionSubmit;
import com.yue.yojbackendjudgeservice.judge.strategy.DefaultJudgeStrategy;
import com.yue.yojbackendjudgeservice.judge.strategy.JavaLanguageJudgeStrategy;
import com.yue.yojbackendjudgeservice.judge.strategy.JudgeContext;
import com.yue.yojbackendjudgeservice.judge.strategy.JudgeStrategy;
import org.springframework.stereotype.Service;

/**
 * 判题管理（简化调用）
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }

}
