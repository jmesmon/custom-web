package com.chxd.policeDog.dao;

import com.chxd.policeDog.vo.PageVO;
import com.chxd.policeDog.vo.TodoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    List<Map> getMyTodo(@Param("nowDay") String nowDay, @Param("next7Day") String next7Day, @Param("nextMonth") String nextMonth,
                        @Param("workUnit") String workUnit, @Param("policeId") String policeId, @Param("applyState") Integer applyState, @Param("eightYearsOld") String eightYearsOld);
}
