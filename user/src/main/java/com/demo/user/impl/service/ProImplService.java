package com.demo.user.impl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.user.entity.TbProject;
import com.demo.user.entity.dto.TbProDto;
import com.demo.user.feign.MqFeignClient;
import com.demo.user.impl.PeoImpl;
import com.demo.user.mapper.ProMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProImplService extends ServiceImpl<ProMapper, TbProject> implements PeoImpl {
    @Autowired
    private ProMapper mapper;

    @Autowired
    private MqFeignClient mqFeignClient;

    @Override
    public String selectTree(TbProject project) throws IOException {
        QueryWrapper<TbProject> qw = new QueryWrapper<>();

        List<TbProject> listAll = mapper.selectList(qw);
        qw.eq("project_code",project.getProjectCode());
        List<TbProject> list = mapper.selectList(qw);
        List<TbProDto> areaTreeModels = new ArrayList<>();
        buildTree(list,areaTreeModels,listAll);
        ObjectMapper om = new ObjectMapper();
        String jackson = om.writeValueAsString(areaTreeModels);

        return jackson.toString();
    }

    @Override
    public String getMqMessage() {
        return mqFeignClient.getMessage();
    }

    private void buildTree(List<TbProject> pareas,List<TbProDto> areaTreeModels,List<TbProject> TpAll){

        pareas.forEach(parent->{
            TbProDto areaTree = new TbProDto();
            areaTree.setId(parent.getId());
            areaTree.setProjectName(parent.getProjectName());
            areaTree.setProjectCode(parent.getProjectCode());
            areaTree.setParentCode(parent.getParentCode());

            areaTree.setChildPro(getChild(parent,TpAll));


            areaTreeModels.add(areaTree);
        });
    }

    private List<TbProDto> getChild(TbProject tbProject,List<TbProject> TpAll){
        List<TbProject> pareas = new ArrayList<>();
        for(TbProject sa:TpAll){
            if(tbProject.getProjectCode().equals(sa.getParentCode())){
                pareas.add(sa);
            }
        }
        TpAll.removeAll(pareas);
        List<TbProject> listC = new ArrayList<>();
        listC.addAll(TpAll);
        List<TbProDto> areaTreeModels = new ArrayList<>();
        buildTree(pareas,areaTreeModels,listC);

        return areaTreeModels.size() == 0 ? null : areaTreeModels;
    }
}
