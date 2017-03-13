package net.lnk.spring.boot.mybatis.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import net.lnk.spring.boot.common.util.Gender;
import net.lnk.spring.boot.mybatis.SpringBootMybatisApplication;
import net.lnk.spring.boot.mybatis.dto.PageableDTO;
import net.lnk.spring.boot.mybatis.model.IdCardEntity;

/**
 * @author Ben
 * @memo 2017年3月2日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { SpringBootMybatisApplication.class })
public class IdCardServiceTest {

	@Autowired
	private IdCardService idCardService;

	@Test
	public void testFindIdCardPageable() {
		IdCardEntity cond = new IdCardEntity();
		cond.setGender(Gender.FEMALE.getGender());
		PageableDTO<IdCardEntity> idCards = idCardService.findIdCardPageable(1, 10, cond);

		System.err.println(JSON.toJSONString(idCards));
	}

}
