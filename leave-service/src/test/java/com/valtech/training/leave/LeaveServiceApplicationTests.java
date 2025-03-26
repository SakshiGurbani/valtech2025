package com.valtech.training.leave;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import java.util.List;
import com.valtech.training.leave.entities.LeaveMaster;
import com.valtech.training.leave.vos.LeaveMasterVO;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class LeaveServiceApplicationTests {

	@LocalServerPort
	private Integer port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void createLevelMastersTest() {
		String baseUrl="http://localhost:"+port+"/api/v1/leaves/";
		List leaveMasters=restTemplate.getForObject(baseUrl, List.class);
		if(leaveMasters.size()==0) {
			restTemplate.postForObject(baseUrl, 
					new LeaveMasterVO(0,5,5,5,1),LeaveMasterVO.class);
			restTemplate.postForObject(baseUrl, 
					new LeaveMasterVO(0,4,4,4,2),LeaveMasterVO.class);
			restTemplate.postForObject(baseUrl, 
					new LeaveMasterVO(0,5,5,5,3),LeaveMasterVO.class);
			restTemplate.postForObject(baseUrl, 
					new LeaveMasterVO(0,3,3,3,4),LeaveMasterVO.class);
			restTemplate.postForObject(baseUrl, 
					new LeaveMasterVO(0,3,3,3,5),LeaveMasterVO.class);
		}
	}

}
