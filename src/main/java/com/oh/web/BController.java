package com.oh.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oh.boardcommand.BCommand;
import com.oh.boardcommand.BContentCommand;
import com.oh.boardcommand.BDeleteCommand;
import com.oh.boardcommand.BListCommand;
import com.oh.boardcommand.BModifyCommand;
import com.oh.boardcommand.BReplyCommand;
import com.oh.boardcommand.BReplyViewCommand;
import com.oh.boardcommand.BWriteCommand;

@Controller
public class BController {

	BCommand command;

	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");

		command = new BListCommand();
		command.execute(model);

		return "list";
	}

	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view()");

		return "write_view";
	}

	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("");

		model.addAttribute("request", request);
		command = new BWriteCommand();
		command.execute(model);

		return "redirect:list";
	}

	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {

		model.addAttribute("request", request);
		command = new BContentCommand();
		command.execute(model);

		return "content_view";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/modify")
	public String modify(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command = new BModifyCommand();
		command.execute(model);
		return "redirect:list";
	}

	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("reply_view");

		model.addAttribute("request", request);
		command = new BReplyViewCommand();
		command.execute(model);
		return "reply_view";
	}

	@RequestMapping("reply")
	public String reply(HttpServletRequest request, Model model) {

		model.addAttribute("request", request);
		command = new BReplyCommand();
		command.execute(model);

		return "redirect:list";
	}

	@RequestMapping("delete")
	public String delete(HttpServletRequest request,Model model){
		
		model.addAttribute("request", request);
		command = new BDeleteCommand();
		command.execute(model);
		
		return"redirect:list";
	}
}
