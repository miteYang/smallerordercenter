package com.demo.user.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.user.entity.TbProject;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;


public interface PeoImpl extends IService<TbProject> {
    String selectTree(TbProject project) throws IOException;

    String getMqMessage();
}
