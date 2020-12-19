package com.exam.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Student;
import com.exam.vo.AnswerVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;


@Mapper
@Service
public interface AnswerMapper {

    @Select("select * from multi_question")
    List<AnswerVO> findMultiAll();

    @Select("select * from judge_question")
    List<AnswerVO> findJudgeAll();

    @Select("select * from fill_question")
    List<AnswerVO> findFillAll();

    @Select("select questionId, question, subject, score, section, level, analysis, answerA, answerB, answerC, answerD, rightAnswer, \"选择题\" as type from multi_question ")
    IPage<AnswerVO> findMultiAllInPage(Page<AnswerVO> page);

    @Select("select questionId, question, subject, score, section, level, analysis, answer, \"判断题\" as type from judge_question ")
    IPage<AnswerVO> findJudgeAllInPage(Page<AnswerVO> page);

    @Select("select questionId, question, subject, score, section, level, analysis, answer, \"填空题\" as type from fill_question")
    IPage<AnswerVO> findFillAllInPage(Page<AnswerVO> page);

    @Update("update fill_question set subject = #{subject},question = #{question},answer = #{answer},analysis = #{analysis}"+
            "score = #{score},level = #{level},section = #{section}" +
            "where questionId = #{questionId}")
    int updateFillQuestion(AnswerVO answerVO);

    @Update("update judge_question set subject = #{subject},question = #{question},answer = #{answer},analysis = #{analysis}"+
            "score = #{score},level = #{level},section = #{section}" +
            "where questionId = #{questionId}")
    int updateJudgeQuestion(AnswerVO answerVO);

    @Update("update multi_question set subject = #{subject},question = #{question}," +
            "answerA = #{answerA},answerB = #{answerB},answerC = #{answerC},answerD = #{answerD}" +
            "rightAnswer = #{rightAnswer},analysis = #{analysis}"+
            "score = #{score},level = #{level},section = #{section}" +
            "where questionId = #{questionId}")
    int updateMultiQuestion(AnswerVO answerVO);

    @Options(useGeneratedKeys = true,keyProperty = "questionId")
    @Insert("insert into multi_question(subject,question,answerA,answerB,answerC,answerD,rightAnswer,analysis,score,section,level) " +
            "values(#{subject},#{question},#{answerA},#{answerB},#{answerC},#{answerD},#{rightAnswer},#{analysis},#{score},#{section},#{level})")
    int addMulti(AnswerVO answerVO);

    @Options(useGeneratedKeys = true,keyProperty = "questionId")
    @Insert("insert into judge_question(subject,question,answer,analysis,score,section,level) " +
            "values(#{subject},#{question},#{answer},#{analysis},#{score},#{section},#{level})")
    int addJudge(AnswerVO answerVO);

    @Options(useGeneratedKeys = true,keyProperty = "questionId")
    @Insert("insert into fill_question(subject,question,answer,analysis,score,section,level) " +
            "values(#{subject},#{question},#{answer},#{analysis},#{score},#{section},#{level})")
    int addFill(AnswerVO answerVO);

    @Delete("delete from multi_question where questionId = #{id}")
    int deleteMultiById(String id);

    @Delete("delete from judge_question where questionId = #{id}")
    int deleteJudgeById(String id);

    @Delete("delete from fill_question where questionId = #{id}")
    int deleteFillById(String id);

    @Select("select * from multi_question where questionId = #{id}")
    AnswerVO findMultiByNumber(String id);

    @Select("select * from judge_question where questionId = #{id}")
    AnswerVO findJudgeByNumber(String id);

    @Select("select * from fill_question where questionId = #{id}")
    AnswerVO findFillByNumber(String id);

}
