package com.loyer.hrsystem;

import com.loyer.hrsystem.model.Job;
import com.loyer.hrsystem.repository.JobRepository;
import com.loyer.hrsystem.service.JobService;
import com.loyer.hrsystem.service.JobServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class JobServiceImplTest {
    private long id;
    @TestConfiguration
    static class JobServiceImplTestContextConfiguration {
        @Autowired
        private JobRepository jobRepository;

        @Bean
         JobService jobService() {
            return new JobServiceImpl(jobRepository);
        }
    }

    @Autowired
    private JobService jobService;

    @MockBean
    private JobRepository jobRepository;

    @Before
    public void setUp() {
        Job job = new Job("title","desc",22,"date");
        jobRepository.save(job);
        id = job.getId();

        Mockito.when(jobRepository.findOne(job.getId()))
                .thenReturn(job);
    }

    @Test
    public void valid() {
        String title = "tite";
        Job found = jobService.getJobById(id);

        assertThat(found.getTitle())
                .isEqualTo(title);
    }

}
