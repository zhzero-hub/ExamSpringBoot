package com.exam.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.vo.AnswerVO;

import java.util.List;

public interface AnswerService {

    List<AnswerVO> findAll();

    IPage<AnswerVO> findMultiAllInPage(Page<AnswerVO> page);

    IPage<AnswerVO> findJudgeAllInPage(Page<AnswerVO> page);

    IPage<AnswerVO> findFillAllInPage(Page<AnswerVO> page);

    int updateFillQuestion(AnswerVO answerVO);

    int updateMultiQuestion(AnswerVO answerVO);

    int updateJudgeQuestion(AnswerVO answerVO);

    int addMulti(AnswerVO answerVO);

    int addJudge(AnswerVO answerVO);

    int addFill(AnswerVO answerVO);

    int deleteMultiById(String id);

    int deleteJudgeById(String id);

    int deleteFillById(String id);

    AnswerVO findMultiById(String id);

    AnswerVO findJudgeById(String id);

    AnswerVO findFillById(String id);
}
