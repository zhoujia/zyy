package com.yingchong.service.data_service;

import com.yingchong.service.data_service.service.ReligionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DataServiceApplication.class)
public class BsServiceApplicationTests {
    @Autowired
    private ReligionService religionService;

	@Test
	public void contextLoads() {
	}

    @Test
    public void testOppositeFilter() {
        religionService.oppositeFilter();
    }

}
