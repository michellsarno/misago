package br.com.misago.bitcoin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.misago.bitcoin.service.ticker.TickerService;
import br.com.misago.bitcoin.vo.TickerVo;

@Controller
@RequestMapping({"/ticker"})
public class TickerController {
	
	@Autowired
	private TickerService tickerService;

	
	@RequestMapping
	public ModelAndView pesquisar(){

		ModelAndView mv = new ModelAndView("Ticker");
		
		List<TickerVo> list = tickerService.getAllTicker();
		
		mv.addObject("tickers", list);
		
		
		return mv;
	}
	
}
