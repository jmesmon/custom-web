package com.chxd.policeDog.dao;

import com.chxd.policeDog.vo.PageVO;
import com.chxd.policeDog.vo.TodoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cheng on 2017/9/3.
 */
@Mapper
@Repository
public interface ITodoDao {
    List<TodoVO> getList(@Param("vo") TodoVO vo, @Param("page") PageVO page);
    Integer getListCount(@Param("vo") TodoVO vo);

    void add(List<TodoVO> list);
    void update(@Param("vo") TodoVO vo);
    void del(List<TodoVO> list);
}
