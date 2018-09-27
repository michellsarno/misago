package br.com.misago.bitcoin.service.orderbook;

import java.util.ArrayList;
import java.util.List;

import br.com.misago.bitcoin.vo.orderbook.OrderbookAskVo;
import br.com.misago.bitcoin.vo.orderbook.OrderbookBidVo;
import br.com.misago.bitcoin.vo.orderbook.OrderbookVo;
import br.com.misago.bitcoin.vo.orderbook.WelcoinOrderbookAsk;
import br.com.misago.bitcoin.vo.orderbook.WelcoinOrderbookBid;
import br.com.misago.bitcoin.vo.orderbook.WelcoinOrderbookVo;

public class OrderbookBRWelcoin extends OrderbookDefault{
	
	private static String NAME = "Welcoin";
	private static String LOCATE = "BR";
	private static String URL = "https://broker.welcoin.com.br/api/v3/#COIN#/orderbook";
	private String coin;
	
	public OrderbookBRWelcoin(String coin){
		
		if(coin.equals("BTC")){
			this.coin = "btcbrl";
		}
		
	}
	
	public OrderbookVo getOrderbook(){
		
		try{
			
			WelcoinOrderbookVo orderbookWelcoinVo = getRestTemplate().getForObject( URL.replace("#COIN#", coin) , WelcoinOrderbookVo.class);
			
			OrderbookVo orderbookVo = new OrderbookVo();
			
			List<OrderbookAskVo> orderbookAskVoList = new ArrayList<OrderbookAskVo>();
			List<OrderbookBidVo> orderbookBidVoList = new ArrayList<OrderbookBidVo>();
			
			
			for (WelcoinOrderbookAsk ask : orderbookWelcoinVo.getAsk()) {
				
				orderbookAskVoList.add( normalizeDataOrderbookAskNegocieCoins(ask) );
				
			}
			
			for (WelcoinOrderbookBid bid : orderbookWelcoinVo.getBid()) {
				
				orderbookBidVoList.add( normalizeDataOrderbookBidNegocieCoins(bid) );
			}
			
			orderbookVo.setOrderbookAsk(orderbookAskVoList);
			orderbookVo.setOrderbookBid(orderbookBidVoList);
			
			return orderbookVo;
			
		}catch (Exception e) {
			return createDefaultObject(NAME, LOCATE, coin);
		}
		
	}
	
	private OrderbookBidVo normalizeDataOrderbookBidNegocieCoins(WelcoinOrderbookBid bid ){

		OrderbookBidVo orderbookBidVo = new OrderbookBidVo();
		
		orderbookBidVo.setExchange(NAME);
		orderbookBidVo.setLocate(LOCATE);
		orderbookBidVo.setPrice(bid.getPrice());
		orderbookBidVo.setQuantity(bid.getQuantity());
		orderbookBidVo.setOrderTotal(orderbookBidVo.getPrice() * orderbookBidVo.getQuantity());
		
		return orderbookBidVo;
	}
	
	
	private OrderbookAskVo normalizeDataOrderbookAskNegocieCoins(WelcoinOrderbookAsk ask ){

		OrderbookAskVo orderbookAskVo = new OrderbookAskVo();
		
		orderbookAskVo.setExchange(NAME);
		orderbookAskVo.setLocate(LOCATE);
		orderbookAskVo.setPrice(ask.getPrice());
		orderbookAskVo.setQuantity(ask.getQuantity());
		orderbookAskVo.setOrderTotal(orderbookAskVo.getPrice() * orderbookAskVo.getQuantity() );
		
		return orderbookAskVo;
	}
}
