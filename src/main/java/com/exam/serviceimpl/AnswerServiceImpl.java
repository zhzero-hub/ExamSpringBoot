package com.exam.serviceimpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.mapper.AnswerMapper;
import com.exam.service.AnswerService;
import com.exam.vo.AnswerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerMapper answerMapper;

    @Override
    public List<AnswerVO> findAll() {
        List<AnswerVO> ret = answerMapper.findMultiAll();
        ret.addAll(answerMapper.findJudgeAll());
        ret.addAll(answerMapper.findFillAll());
        return ret;
    }

    @Override
    public IPage<AnswerVO> findMultiAllInPage(Page<AnswerVO> page) {
        return answerMapper.findMultiAllInPage(page);
    }

    @Override
    public IPage<AnswerVO> findJudgeAllInPage(Page<AnswerVO> page) {
        return answerMapper.findJudgeAllInPage(page);
    }

    @Override
    public IPage<AnswerVO> findFillAllInPage(Page<AnswerVO> page) {
        return answerMapper.findFillAllInPage(page);
    }

    @Override
    public int updateFillQuestion(AnswerVO answerVO) {
        return answerMapper.updateFillQuestion(answerVO);
    }

    @Override
    public int updateMultiQuestion(AnswerVO answerVO) {
        return answerMapper.updateMultiQuestion(answerVO);
    }

    @Override
    public int updateJudgeQuestion(AnswerVO answerVO) {
        return answerMapper.updateJudgeQuestion(answerVO);
    }

    @Override
    public int addMulti(AnswerVO answerVO) {
        return answerMapper.addMulti(answerVO);
    }

    @Override
    public int addJudge(AnswerVO answerVO) {
        return answerMapper.addJudge(answerVO);
    }

    @Override
    public int addFill(AnswerVO answerVO) {
        return answerMapper.addFill(answerVO);
    }

    @Override
    public int deleteMultiById(String id) {
        return answerMapper.deleteMultiById(id);
    }

    @Override
    public int deleteJudgeById(String id) {
        return answerMapper.deleteJudgeById(id);
    }

    @Override
    public int deleteFillById(String id) {
        return answerMapper.deleteFillById(id);
    }

    @Override
    public AnswerVO findMultiById(String id) {
        return answerMapper.findMultiByNumber(id);
    }

    @Override
    public AnswerVO findJudgeById(String id) {
        return answerMapper.findJudgeByNumber(id);
    }

    @Override
    public AnswerVO findFillById(String id) {
        return answerMapper.findFillByNumber(id);
    }

}
