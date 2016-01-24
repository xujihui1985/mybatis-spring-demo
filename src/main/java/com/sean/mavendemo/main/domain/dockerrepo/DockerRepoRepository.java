package com.sean.mavendemo.main.domain.dockerrepo;

/**
 * Created by sean on 1/10/16.
 */
public interface DockerRepoRepository {

    void insert(final DockerRepo repo);
    void update(final DockerRepo repo);
    DockerRepo Load(final Long id);
}
