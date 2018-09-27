package br.com.misago.bitcoin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/", "", "/"})
public class DashboardController {
	
	@RequestMapping
	public String index(){

		return "dashboard";
	}
	
}
