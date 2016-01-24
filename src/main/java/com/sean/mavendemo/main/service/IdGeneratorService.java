package com.sean.mavendemo.main.service;

import com.sean.mavendemo.main.mapper.DockerRepoMapper;
import com.sean.mavendemo.main.mapper.RepoTagMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sean on 1/24/16.
 */
public interface IdGeneratorService {


    Integer nextId(Class<?> entityClass);
}
