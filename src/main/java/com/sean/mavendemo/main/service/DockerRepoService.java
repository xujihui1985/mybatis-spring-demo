package com.sean.mavendemo.main.service;

import com.sean.mavendemo.main.domain.dockerrepo.DockerRepo;

/**
 * Created by sean on 1/17/16.
 */
public interface DockerRepoService {

    void insert(DockerRepo repo);

    DockerRepo queryByRepoId(Long id);

}
