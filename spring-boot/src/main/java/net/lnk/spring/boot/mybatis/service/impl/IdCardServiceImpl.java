package net.lnk.spring.boot.mybatis.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import net.lnk.spring.boot.common.util.Gender;
import net.lnk.spring.boot.mybatis.dto.PageableDTO;
import net.lnk.spring.boot.mybatis.mapper.IdCardMapper;
import net.lnk.spring.boot.mybatis.model.IdCardEntity;
import net.lnk.spring.boot.mybatis.service.IdCardService;
import tk.mybatis.mapper.entity.Example;

/**
 * @author Ben
 * @memo 2017年3月2日
 */
@Service
public class IdCardServiceImpl implements IdCardService {

	@Autowired
	private IdCardMapper idCardMapper;

	public PageableDTO<IdCardEntity> findIdCardPageable(int pageNum, int pageSize, IdCardEntity cond) {
		PageHelper.startPage(pageNum, pageSize, true);
		Example example = new Example(IdCardEntity.class);
		example.createCriteria().andEqualTo("gender", Gender.MALE.getGender());
		example.setOrderByClause("create_time desc");
		List<IdCardEntity> idCards = idCardMapper.selectByExample(example);
		
		PageableDTO<IdCardEntity> idCardsDTO = new PageableDTO<IdCardEntity>();
		idCardsDTO.initFromPage(idCards);
		
		List<IdCardEntity> cardList = new ArrayList<IdCardEntity>();
		for(IdCardEntity idCard : idCards){
			cardList.add(idCard);
		}
		idCardsDTO.setList(cardList);
		
		return idCardsDTO;
	}

}
