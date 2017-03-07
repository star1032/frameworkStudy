package com.oh.boardcommand;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.oh.dao.BDao;
import com.oh.domain.BDto;

public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) {

		BDao dao= new BDao();
		ArrayList<BDto> dtos= dao.list();
		
		model.addAttribute("list", dtos);
		
		
	}

}
