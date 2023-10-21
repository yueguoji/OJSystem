package com.yue.yojbackendjudgeservice.judge.codesandbox.impl;

import com.yue.yojBackendModel.model.codeSandbox.ExecuteCodeRequest;
import com.yue.yojBackendModel.model.codeSandbox.ExecuteCodeResponse;
import com.yue.yojbackendjudgeservice.judge.codesandbox.CodeSandbox;

/**
 * 第三方代码沙箱（调用网上现成的代码沙箱）
 */
public class ThirdPartyCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("第三方代码沙箱");
        return null;
    }
}
