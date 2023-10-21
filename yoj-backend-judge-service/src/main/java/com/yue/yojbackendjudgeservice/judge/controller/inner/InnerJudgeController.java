package com.yue.yojbackendjudgeservice.judge.controller.inner;

import com.yue.yojBackendModel.model.entity.QuestionSubmit;
import com.yue.yojbackendjudgeservice.judge.JudgeService;
import com.yue.yojbackendserviceclient.service.JudgeFeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Yuuue
 * creat by 2023-10-05
 */
@RestController
@RequestMapping("/inner")
public class InnerJudgeController implements JudgeFeignClient {

    @Resource
    private JudgeService judgeService;

    /**
     * 判题
     *
     * @param questionSubmitId
     * @return
     */
    @Override
    public QuestionSubmit doJudge(long questionSubmitId) {
        return judgeService.doJudge(questionSubmitId);
    }
}
