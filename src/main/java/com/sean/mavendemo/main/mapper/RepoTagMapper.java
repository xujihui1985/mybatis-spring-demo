package com.sean.mavendemo.main.mapper;

import com.sean.mavendemo.main.mapper.persistencemodal.RepoTag;
import org.apache.ibatis.annotations.Param;

/**
 * Created by sean on 1/17/16.
 */
public interface RepoTagMapper {

    void insert(RepoTag tag);


}
