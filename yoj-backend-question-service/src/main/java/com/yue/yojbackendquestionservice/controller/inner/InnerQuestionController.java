package com.yue.yojbackendquestionservice.controller.inner;

import com.yue.yojBackendModel.model.entity.Question;
import com.yue.yojBackendModel.model.entity.QuestionSubmit;
import com.yue.yojbackendquestionservice.service.QuestionService;
import com.yue.yojbackendquestionservice.service.QuestionSubmitService;
import com.yue.yojbackendserviceclient.service.QuestionFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Yuuue
 * creat by 2023-10-05
 */
@RestController
@RequestMapping("/inner")
public class InnerQuestionController implements QuestionFeignClient {

    @Resource
    private QuestionService questionService;

    @Resource
    private QuestionSubmitService questionSubmitService;

    /**
     * 获取题目
     *
     * @param questionId
     * @return
     */
    @Override
    @GetMapping("/get/id")
    public Question getQuestionById(Long questionId) {
        return questionService.getById(questionId);
    }

    /**
     * 获取题目
     *
     * @param questionSunmitId
     * @return
     */
    @Override
    @GetMapping("/question_submit/get/id")
    public QuestionSubmit getQuestionSubmitById(Long questionSunmitId) {
        return questionSubmitService.getById(questionSunmitId);
    }

    /**
     * 获取题目
     *
     * @param questionSubmitUpdate
     * @return
     */
    @Override
    @PostMapping("/question_submit/update")
    public boolean updateQuestionSubmitById(QuestionSubmit questionSubmitUpdate) {
        return questionSubmitService.updateById(questionSubmitUpdate);
    }
}
