package com.exam.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.ApiResult;
import com.exam.entity.Student;
import com.exam.serviceimpl.AnswerServiceImpl;
import com.exam.util.ApiResultHandler;
import com.exam.vo.AnswerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class AnswerController {

    @Autowired
    private AnswerServiceImpl answerService;

    @GetMapping("/answers")
    public ApiResult findAll() {
        List<AnswerVO> answerVOList = answerService.findAll();
        return ApiResultHandler.buildApiResult(200,"查询所有题库",answerVOList);
    }

    @GetMapping("/answers/multi/{page}/{size}")
    public ApiResult findMultiAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
       Page<AnswerVO> answerVOPage = new Page<>(page,size);
       IPage<AnswerVO> answerVOIPage = answerService.findMultiAllInPage(answerVOPage);
       return ApiResultHandler.buildApiResult(200,"查询所有题库",answerVOIPage);
    }

    @GetMapping("/answers/judge/{page}/{size}")
    public ApiResult findJudgeAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        Page<AnswerVO> answerVOPage = new Page<>(page,size);
        IPage<AnswerVO> answerVOIPage = answerService.findJudgeAllInPage(answerVOPage);
        return ApiResultHandler.buildApiResult(200,"查询所有题库",answerVOIPage);
    }

    @GetMapping("/answers/fill/{page}/{size}")
    public ApiResult findFillAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        Page<AnswerVO> answerVOPage = new Page<>(page,size);
        IPage<AnswerVO> answerVOIPage = answerService.findFillAllInPage(answerVOPage);
        return ApiResultHandler.buildApiResult(200,"查询所有题库",answerVOIPage);
    }

    @PutMapping("/answers")
    public ApiResult update(@RequestBody AnswerVO answerVO) {
        int res = 0;
        if(answerVO.getType().isEmpty()) {
            return ApiResultHandler.buildApiResult(400 , "更新失败" , res);
        }
        else if(answerVO.getType().equals("选择题")) {
            res = answerService.updateMultiQuestion(answerVO);
        }
        else if(answerVO.getType().equals("判断题")) {
            res = answerService.updateJudgeQuestion(answerVO);
        }
        else if(answerVO.getType().equals("填空题")) {
            res = answerService.updateFillQuestion(answerVO);
        }
        if (res != 0) {
            return ApiResultHandler.buildApiResult(200,"更新成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"更新失败",res);
    }

    @PutMapping("/answers/multi")
    public ApiResult updateMulti(@RequestBody AnswerVO answerVO) {
        int res = answerService.updateMultiQuestion(answerVO);
        if (res != 0) {
            return ApiResultHandler.buildApiResult(200,"更新成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"更新失败",res);
    }

    @PutMapping("/answers/judge")
    public ApiResult updateJudge(@RequestBody AnswerVO answerVO) {
        int res = answerService.updateJudgeQuestion(answerVO);
        if (res != 0) {
            return ApiResultHandler.buildApiResult(200,"更新成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"更新失败",res);
    }

    @PutMapping("/answers/fill")
    public ApiResult updateFill(@RequestBody AnswerVO answerVO) {
        int res = answerService.updateFillQuestion(answerVO);
        if (res != 0) {
            return ApiResultHandler.buildApiResult(200,"更新成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"更新失败",res);
    }

    @PostMapping("/answer/multi")
    public ApiResult addMulti(@RequestBody AnswerVO answerVO) {
        int res = answerService.addMulti(answerVO);
        if(res != 0) {
            return ApiResultHandler.buildApiResult(200,"选择题添加成功",res);
        }
        else {
            return ApiResultHandler.buildApiResult(400,"选择题添加失败",res);
        }
    }

    @PostMapping("/answer/judge")
    public ApiResult addJudge(@RequestBody AnswerVO answerVO) {
        int res = answerService.addJudge(answerVO);
        if(res != 0) {
            return ApiResultHandler.buildApiResult(200,"判断题添加成功",res);
        }
        else {
            return ApiResultHandler.buildApiResult(400,"判断题添加失败",res);
        }
    }

    @PostMapping("/answer/fill")
    public ApiResult addFill(@RequestBody AnswerVO answerVO) {
        int res = answerService.addFill(answerVO);
        if(res != 0) {
            return ApiResultHandler.buildApiResult(200,"填空题添加成功",res);
        }
        else {
            return ApiResultHandler.buildApiResult(400,"填空题添加失败",res);
        }
    }

    @DeleteMapping("/answer/multi/{questionId}")
    public ApiResult deleteMultiById(@PathVariable("questionId") String questionId) {
        return ApiResultHandler.buildApiResult(200, "选择题删除成功", answerService.deleteMultiById(questionId));
    }

    @DeleteMapping("/answer/judge/{questionId}")
    public ApiResult deleteJudgeById(@PathVariable("questionId") String questionId) {
        return ApiResultHandler.buildApiResult(200, "判断题删除成功", answerService.deleteJudgeById(questionId));
    }

    @DeleteMapping("/answer/fill/{questionId}")
    public ApiResult deleteFillById(@PathVariable("questionId") String questionId) {
        return ApiResultHandler.buildApiResult(200, "填空题删除成功", answerService.deleteFillById(questionId));
    }

    @GetMapping("/answer/multi/{questionId}")
    public ApiResult findMultiById(@PathVariable("questionId") String questionId) {
        AnswerVO res = answerService.findMultiById(questionId);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        } else {
            return ApiResultHandler.buildApiResult(404,"查询的题目不存在",null);
        }
    }

    @GetMapping("/answer/judge/{questionId}")
    public ApiResult findJudgeById(@PathVariable("questionId") String questionId) {
        AnswerVO res = answerService.findJudgeById(questionId);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        } else {
            return ApiResultHandler.buildApiResult(404,"查询的题目不存在",null);
        }
    }

    @GetMapping("/answer/fill/{questionId}")
    public ApiResult findFillById(@PathVariable("questionId") String questionId) {
        AnswerVO res = answerService.findFillById(questionId);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        } else {
            return ApiResultHandler.buildApiResult(404,"查询的题目不存在",null);
        }
    }
}
