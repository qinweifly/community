package life.qinwei.community.schedule;

import life.qinwei.community.cache.HotTagCache;
import life.qinwei.community.mapper.QuestionMapper;
import life.qinwei.community.model.Question;
import life.qinwei.community.model.QuestionExample;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Slf4j
public class HotTagTasks {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private HotTagCache hotTagCache;

    @Scheduled(fixedRate = 20000)
//    @Scheduled(cron = "0 0 1 * * *")
    public void hotTagSchedule() {
        int offset = 0;
        int limit = 20;
        log.info("hotTagSchedule start {}", new Date());
        List<Question> list = new ArrayList<>();
        Map<String, Integer> tagPriorities = new HashMap<>();
        while (offset == 0 || list.size() == limit) {
            list = questionMapper.selectByExampleWithRowbounds(new QuestionExample(), new RowBounds(offset, limit));
            for (Question question : list) {
                String[] tags = StringUtils.split(question.getTag(), ",");
                for (String tag : tags) {
                    Integer priority = tagPriorities.get(tag);
                    if (priority != null) {
                        tagPriorities.put(tag, priority + 5 + question.getCommentCount());
                    } else {
                        tagPriorities.put(tag, 5 + question.getCommentCount());
                    }
                }
            }
            offset += limit;
        }
        hotTagCache.updateTags(tagPriorities);
        log.info("hotTagSchedule stop {}", new Date());
    }
}
