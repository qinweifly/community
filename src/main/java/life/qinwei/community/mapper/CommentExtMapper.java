package life.qinwei.community.mapper;

import life.qinwei.community.model.Comment;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}