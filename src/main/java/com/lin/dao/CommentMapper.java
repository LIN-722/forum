package com.lin.dao;

import com.lin.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    // 根据实体类类型和id查询对应评论（分页）
    List<Comment> selectCommentsByEntity(int entityType, int entityId, int offset, int limit);

    // 根据实体类类型和id查询评论数目
    int selectCountByEntity(int entityType, int entityId);
}
