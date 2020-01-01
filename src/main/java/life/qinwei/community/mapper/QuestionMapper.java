package life.qinwei.community.mapper;

import life.qinwei.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Insert("insert into question (TITLE, DESCRIPTION, GMT_CREATE, GMT_MODIFIED, CREATOR, TAG) values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void create(Question question);

    @Select("select * from question limit #{offSet},#{size}")
    List<Question> list(@Param(value = "offSet") Integer offSet, @Param(value = "size")Integer size);

    @Select("select count(1) from QUESTION")
    Integer count();
}