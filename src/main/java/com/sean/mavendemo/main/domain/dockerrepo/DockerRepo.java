package com.sean.mavendemo.main.domain.dockerrepo;

import org.apache.ibatis.type.Alias;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by sean on 1/10/16.
 */
public class DockerRepo {

    private Long id;
    private String repoName;
    private String description;
    private Date createdDate;
    private Date modifiedDate;
    private Integer version;
    private final List<RepoTag> repoTags = new ArrayList<>();


    public List<RepoTag> getRepoTags() {
        return repoTags;
    }

    public void addRepoTags(RepoTag tag) {
        this.repoTags.add(tag);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
