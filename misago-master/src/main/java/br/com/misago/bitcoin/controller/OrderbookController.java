package br.com.misago.bitcoin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.misago.bitcoin.service.orderbook.OrderbookService;
import br.com.misago.bitcoin.vo.orderbook.OrderbookVo;

@Controller
@RequestMapping({"/orderbook", "", "/"})
public class OrderbookController {
	
	@Autowired
	private OrderbookService service;

	@RequestMapping
	public ModelAndView orderbook(){

		ModelAndView mv = new ModelAndView("orderbook");
		
		OrderbookVo orderbookVo = service.getAllOrderbookAsk();
		
		mv.addObject("askList", orderbookVo.getOrderbookAsk());
		mv.addObject("bidList", orderbookVo.getOrderbookBid());
		
		
		return mv;
	}
	
}
