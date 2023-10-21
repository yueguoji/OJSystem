package com.yue.yojbackendjudgeservice.judge.strategy;

import com.yue.yojBackendModel.model.codeSandbox.JudgeInfo;

/**
 * 判题策略
 */
public interface JudgeStrategy {

    /**
     * 执行判题
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext);
}
