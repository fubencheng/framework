package net.lnk.spring.boot.thymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.lnk.spring.boot.common.util.Gender;
import net.lnk.spring.boot.thymeleaf.mapper.IdCardMapper;
import net.lnk.spring.boot.thymeleaf.model.IdCardEntity;
import tk.mybatis.mapper.entity.Example;

/**
 * @author Ben
 * @memo 2017年2月28日
 */
@Controller
public class IndexController {

	@Autowired
	private IdCardMapper idCardMapper;

	@RequestMapping(path = "/index", method = RequestMethod.GET)
	public String index(Model model) {

		Example cond = new Example(IdCardEntity.class);
		cond.createCriteria().andEqualTo("gender", Gender.FEMALE.getGender());
		List<IdCardEntity> idCards = idCardMapper.selectByExample(cond);

		model.addAttribute("name", "Ben");
		model.addAttribute("idCards", idCards);

		return "index";
	}

}
