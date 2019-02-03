package com.mql.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PaiementController {

	@RequestMapping("/payer")
	public String payer() {
		return "success";
	}
}
