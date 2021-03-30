package com.demo.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.user.entity.TbProject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProMapper extends BaseMapper<TbProject> {

    List<TbProject> selectByDto(TbProject tbProject);
}
