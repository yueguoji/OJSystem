package com.yue.yojbackendserviceclient.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yue.yojBackendModel.model.dto.question.QuestionQueryRequest;
import com.yue.yojBackendModel.model.entity.Question;
import com.yue.yojBackendModel.model.entity.QuestionSubmit;
import com.yue.yojBackendModel.model.vo.QuestionVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
* @author 李鱼皮
* @description 针对表【question(题目)】的数据库操作Service
* @createDate 2023-08-07 20:58:00
*/
@FeignClient(name = "yoj-backend-question-service",path = "/api/question/inner")
public interface QuestionFeignClient  {

    /**
     * 获取题目
     * @param questionId
     * @return
     */
    @GetMapping("/get/id")
    Question getQuestionById(@RequestParam("questionId") Long questionId);

    /**
     * 获取题目
     * @param questionSunmitId
     * @return
     */
    @GetMapping("/question_submit/get/id")
    QuestionSubmit getQuestionSubmitById(Long questionSunmitId);

    /**
     * 获取题目
     * @param questionSubmitUpdate
     * @return
     */
    @PostMapping("/question_submit/update")
    boolean updateQuestionSubmitById(@RequestBody QuestionSubmit questionSubmitUpdate);
}
