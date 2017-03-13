package net.lnk.spring.boot.mybatis.service;

import net.lnk.spring.boot.mybatis.dto.PageableDTO;
import net.lnk.spring.boot.mybatis.model.IdCardEntity;

/**
 * @author Ben
 * @memo 2017年3月2日
 */
public interface IdCardService {

	public PageableDTO<IdCardEntity> findIdCardPageable(int pageNum, int pageSize, IdCardEntity cond);

}
