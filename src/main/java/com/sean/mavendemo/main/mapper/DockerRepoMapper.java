package com.sean.mavendemo.main.mapper;

import com.sean.mavendemo.main.mapper.persistencemodal.DockerRepo;

/**
 * Created by sean on 1/17/16.
 */
public interface DockerRepoMapper {

    void insert(DockerRepo dockerRepo);
    DockerRepo queryRepoById(Long id);
}
