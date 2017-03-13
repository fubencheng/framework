package net.lnk.spring.boot.mybatis.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import net.lnk.spring.boot.mybatis.SpringBootMybatisApplication;
import net.lnk.spring.boot.mybatis.model.IdCardEntity;

/**
 * @author Ben
 * @memo 2017年3月1日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { SpringBootMybatisApplication.class })
public class IdCardMapperTest {

	@Autowired
	private IdCardMapper idCardMapper;

	@Test
	public void testSelectByPrimaryKey() {
		IdCardEntity idCard = idCardMapper.selectByPrimaryKey(10001L);

		System.err.println(JSON.toJSONString(idCard));
	}

}
