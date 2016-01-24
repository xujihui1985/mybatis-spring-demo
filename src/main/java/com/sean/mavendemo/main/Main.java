package com.sean.mavendemo.main;

import com.sean.mavendemo.main.mapper.persistencemodal.Goal;
import com.sean.mavendemo.main.domain.dockerrepo.DockerRepo;
import com.sean.mavendemo.main.domain.dockerrepo.DockerRepoRepository;
import com.sean.mavendemo.main.domain.dockerrepo.RepoTag;
import com.sean.mavendemo.main.service.DockerRepoService;
import com.sean.mavendemo.main.service.GoalService;
import com.sean.mavendemo.main.service.IdGeneratorService;
import org.apache.commons.lang.Validate;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * Created by sean on 12/19/15.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        //baseMybatis();
//        useSpringMybatis();
        insertDockerRepo();
      //  queryById();
      //  idGenerator();
    }

    private static void baseMybatis() {
        Validate.isTrue(true);
        SqlSession sqlSession = null;
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            LogFactory.useLog4JLogging();
            sqlSession = factory.openSession();
//            GoalMapper goalMapper = sqlSession.getMapper(GoalMapper.class);
//            Integer result = goalMapper.getCountForGoal();
//            System.out.printf("result is %s \n", result.toString());
//            Goal g = goalMapper.getGoalById(1);
//            System.out.println("goal result is " + g.getMinutes());
//
//
//            Goal goalToSave = new Goal();
//            goalToSave.setMinutes(200);
//
//            goalMapper.insert(goalToSave);
//
//            Goal goalToUpdate = goalMapper.getGoalById(6);
//            goalToUpdate.setMinutes(1000);
//
//            goalMapper.update(goalToUpdate);
//
//            sqlSession.commit();
//
//            System.out.println(goalToSave.getId());
//
//            List<Goal> goals = goalMapper.getGoals();
//
//            for(Goal g1 : goals) {
//                System.out.println(g1);
//            }


            DockerRepo repo = new DockerRepo();
            repo.setCreatedDate(new Date());
            repo.setModifiedDate(new Date());
            repo.setVersion(1);
            repo.setRepoName("hello");
            repo.setDescription("ccccc");

            RepoTag tag = new RepoTag();
            tag.setVersion(1);
            tag.setTagName("master");
            tag.setGitBranchName("master");

            RepoTag tag2 = new RepoTag();
            tag.setVersion(1);
            tag.setTagName("develop");
            tag.setGitBranchName("develop");

            repo.addRepoTags(tag);
            repo.addRepoTags(tag2);

            DockerRepoRepository dockerRepoRepository = sqlSession.getMapper(DockerRepoRepository.class);
            dockerRepoRepository.insert(repo);
            sqlSession.commit();


        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        } finally {
            if(sqlSession != null) {

                sqlSession.close();
            }

        }
    }

    private static void useSpringMybatis() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");

        GoalService service = ctx.getBean(GoalService.class);
        Goal goal = service.getById(1);
        System.out.println(goal);

        service.insertMultiple();
        //GoalMapper goalMapper = ctx.getBean(GoalMapper.class);

        //Integer countForGoal = goalMapper.getCountForGoal();
        //System.out.println(countForGoal);
    }

    private static void insertDockerRepo() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");

        DockerRepoService service = ctx.getBean(DockerRepoService.class);

        DockerRepo repo = new DockerRepo();
        repo.setCreatedDate(new Date());
        repo.setModifiedDate(new Date());
        repo.setVersion(1);
        repo.setRepoName("hello");
        repo.setDescription("ccccc");

        RepoTag tag = new RepoTag();
        tag.setVersion(1);
        tag.setTagName("master");
        tag.setGitBranchName("master");

        RepoTag tag2 = new RepoTag();
        tag.setVersion(1);
        tag.setTagName("develop");
        tag.setGitBranchName("develop");

       // repo.addRepoTags(tag);
        //repo.addRepoTags(tag2);

        service.insert(repo);
        service.insert(repo);
        service.insert(repo);
        service.insert(repo);
    }

    private static void queryById() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");

        DockerRepoService service = ctx.getBean(DockerRepoService.class);

        DockerRepo dockerRepo = service.queryByRepoId(12L);


        System.out.println(dockerRepo);



    }

    private static void idGenerator() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");

        IdGeneratorService service = ctx.getBean(IdGeneratorService.class);

        System.out.println(service.nextId(DockerRepo.class));
        System.out.println(service.nextId(DockerRepo.class));
        System.out.println(service.nextId(DockerRepo.class));
        System.out.println(service.nextId(DockerRepo.class));
        System.out.println(service.nextId(DockerRepo.class));



    }


}
