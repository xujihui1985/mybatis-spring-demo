package com.sean.mavendemo.main.service.impl;

import com.sean.mavendemo.main.domain.dockerrepo.DockerRepo;
import com.sean.mavendemo.main.domain.dockerrepo.RepoTag;
import com.sean.mavendemo.main.mapper.DockerRepoMapper;
import com.sean.mavendemo.main.mapper.RepoTagMapper;
import com.sean.mavendemo.main.service.DockerRepoService;
import com.sean.mavendemo.main.service.IdGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sean on 1/17/16.
 */

@Component
public class DockerRepoServiceImpl implements DockerRepoService {

    private final DockerRepoMapper dockerRepoMapper;
    private final RepoTagMapper tagMapper;
    private final IdGeneratorService idGeneratorService;

    @Autowired
    public DockerRepoServiceImpl(DockerRepoMapper dockerRepoMapper,
                                 RepoTagMapper tagMapper,
                                 IdGeneratorService idGeneratorService) {
        this.dockerRepoMapper = dockerRepoMapper;
        this.tagMapper = tagMapper;
        this.idGeneratorService = idGeneratorService;
    }

    @Override
    @Transactional
    public void insert(DockerRepo repo) {
        Integer id = this.idGeneratorService.nextId(DockerRepo.class);
        com.sean.mavendemo.main.mapper.persistencemodal.DockerRepo repoDO = new com.sean.mavendemo.main.mapper.persistencemodal.DockerRepo();
        repoDO.setId(id.longValue());
        repoDO.setRepoName(repo.getRepoName());
        repoDO.setDescription(repo.getDescription());
        repoDO.setVersion(repo.getVersion());
        repoDO.setCreatedDate(repo.getCreatedDate());
        repoDO.setModifiedDate(repo.getModifiedDate());

        this.dockerRepoMapper.insert(repoDO);

        if (repo.getRepoTags().size() > 0) {

            for (RepoTag tag : repo.getRepoTags()) {

                com.sean.mavendemo.main.mapper.persistencemodal.RepoTag tagDO = new com.sean.mavendemo.main.mapper.persistencemodal.RepoTag();
                tagDO.setGitBranchName(tag.getGitBranchName());
                tagDO.setTagName(tag.getTagName());
                tagDO.setGitTagName(tag.getGitTagName());
                tagDO.setDockerRepoId(repoDO.getId());
                tagDO.setVersion(repoDO.getVersion());
                this.tagMapper.insert(tagDO);
            }
        }

    }

    @Override
    public DockerRepo queryByRepoId(Long id) {
        return null;
      //  return this.dockerRepoMapper.queryRepoById(id);
    }
}
