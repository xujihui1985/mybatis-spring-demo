package com.sean.mavendemo.main.domain.dockerrepo;

import org.apache.ibatis.type.Alias;

/**
 * Created by sean on 1/10/16.
 */
public class RepoTag {

    private Long id;
    private Integer version;
    private Long dockerRepoId;

    private String tagName;
    private String gitBranchName;
    private String gitTagName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Long getDockerRepoId() {
        return dockerRepoId;
    }

    public void setDockerRepoId(Long dockerRepoId) {
        this.dockerRepoId = dockerRepoId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getGitBranchName() {
        return gitBranchName;
    }

    public void setGitBranchName(String gitBranchName) {
        this.gitBranchName = gitBranchName;
    }

    public String getGitTagName() {
        return gitTagName;
    }

    public void setGitTagName(String gitTagName) {
        this.gitTagName = gitTagName;
    }
}
