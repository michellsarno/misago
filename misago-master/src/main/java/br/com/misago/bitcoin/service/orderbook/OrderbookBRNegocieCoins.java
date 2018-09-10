package br.com.misago.bitcoin.service.orderbook;

import java.util.ArrayList;
import java.util.List;

import br.com.misago.bitcoin.service.ConnectionApiRestService;
import br.com.misago.bitcoin.vo.orderbook.NegocieCoinsOrderbookAsk;
import br.com.misago.bitcoin.vo.orderbook.NegocieCoinsOrderbookBid;
import br.com.misago.bitcoin.vo.orderbook.NegocieCoisOrderbookVo;
import br.com.misago.bitcoin.vo.orderbook.OrderbookAskVo;
import br.com.misago.bitcoin.vo.orderbook.OrderbookBidVo;
import br.com.misago.bitcoin.vo.orderbook.OrderbookVo;

public class OrderbookBRNegocieCoins extends ConnectionApiRestService{
	

	private static String NAME = "NegocieCoins";
	private static String LOCATE = "BR";
	private static String URL = "https://broker.negociecoins.com.br/api/v3/#COIN#/orderbook";
	
	private String coin;
	
	public OrderbookBRNegocieCoins(String coin){
		
		if(coin.equals("BTC")){
			this.coin = "btcbrl";
		}
		
	}
	
	public OrderbookVo getOrderbook(){
		
		NegocieCoisOrderbookVo orderbookNegocieCoinsVo = getRestTemplate().getForObject( URL.replace("#COIN#", coin) , NegocieCoisOrderbookVo.class);
		
		OrderbookVo orderbookVo = new OrderbookVo();
		
		List<OrderbookAskVo> orderbookAskVoList = new ArrayList<OrderbookAskVo>();
		List<OrderbookBidVo> orderbookBidVoList = new ArrayList<OrderbookBidVo>();
		
		
		for (NegocieCoinsOrderbookAsk ask : orderbookNegocieCoinsVo.getAsk()) {
			
			orderbookAskVoList.add( normalizeDataOrderbookAskNegocieCoins(ask) );
			
		}
		
		for (NegocieCoinsOrderbookBid bid : orderbookNegocieCoinsVo.getBid()) {
			
			orderbookBidVoList.add( normalizeDataOrderbookBidNegocieCoins(bid) );
		}
		
		orderbookVo.setOrderbookAsk(orderbookAskVoList);
		orderbookVo.setOrderbookBid(orderbookBidVoList);
		
		return orderbookVo;
		
	}
	
	private OrderbookBidVo normalizeDataOrderbookBidNegocieCoins(NegocieCoinsOrderbookBid bid ){

		OrderbookBidVo orderbookBidVo = new OrderbookBidVo();
		
		orderbookBidVo.setExchange(NAME);
		orderbookBidVo.setLocate(LOCATE);
		orderbookBidVo.setPrice(bid.getPrice());
		orderbookBidVo.setQuantity(bid.getQuantity());
		
		return orderbookBidVo;
	}
	
	
	private OrderbookAskVo normalizeDataOrderbookAskNegocieCoins(NegocieCoinsOrderbookAsk ask ){

		OrderbookAskVo orderbookAskVo = new OrderbookAskVo();
		
		orderbookAskVo.setExchange(NAME);
		orderbookAskVo.setLocate(LOCATE);
		orderbookAskVo.setPrice(ask.getPrice());
		orderbookAskVo.setQuantity(ask.getQuantity());
		
		return orderbookAskVo;
	}
}
