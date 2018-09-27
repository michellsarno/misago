package br.com.misago.bitcoin.service.orderbook;

import java.util.ArrayList;
import java.util.List;

import br.com.misago.bitcoin.service.ConnectionApiRestService;
import br.com.misago.bitcoin.vo.orderbook.OrderbookAskVo;
import br.com.misago.bitcoin.vo.orderbook.OrderbookBidVo;
import br.com.misago.bitcoin.vo.orderbook.OrderbookVo;

public class OrderbookDefault extends ConnectionApiRestService {

	public OrderbookVo createDefaultObject(String name, String locate, String coin){
		
		OrderbookVo orderbookVo = new OrderbookVo();
		
		List<OrderbookAskVo> orderbookAskVoList = new ArrayList<OrderbookAskVo>();
		List<OrderbookBidVo> orderbookBidVoList = new ArrayList<OrderbookBidVo>();
		
		orderbookAskVoList.add( createDefaultAskVo(name, locate) );
		
		orderbookBidVoList.add( createDefaultBidVo(name, locate) );
		
		orderbookVo.setOrderbookAsk(orderbookAskVoList);
		orderbookVo.setOrderbookBid(orderbookBidVoList);
		
		return orderbookVo;
		
	}
	
	private OrderbookBidVo createDefaultBidVo( String name, String locate){

		OrderbookBidVo orderbookBidVo = new OrderbookBidVo();
		
		orderbookBidVo.setExchange(name);
		orderbookBidVo.setLocate(locate);
		orderbookBidVo.setPrice(0.0);
		orderbookBidVo.setQuantity(0.0);
		orderbookBidVo.setOrderTotal(0.0);
		
		return orderbookBidVo;
	}
	
	
	private OrderbookAskVo createDefaultAskVo(String name, String locate){

		OrderbookAskVo orderbookAskVo = new OrderbookAskVo();
		
		orderbookAskVo.setExchange(name);
		orderbookAskVo.setLocate(locate);
		orderbookAskVo.setPrice(0.0);
		orderbookAskVo.setQuantity(0.0);
		orderbookAskVo.setOrderTotal(0.0);
		
		return orderbookAskVo;
	}
	
}
