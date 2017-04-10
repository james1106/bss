package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerViewController {

	@RequestMapping(value="cstmls/show",method=RequestMethod.GET)
	public String showCustomerView(){
		return "cust/list";
	}
}
