package br.com.misago.bitcoin.service.orderbook;

import java.util.ArrayList;
import java.util.List;

import br.com.misago.bitcoin.vo.orderbook.MercadoBitcoinOrderbookVo;
import br.com.misago.bitcoin.vo.orderbook.OrderbookAskVo;
import br.com.misago.bitcoin.vo.orderbook.OrderbookBidVo;
import br.com.misago.bitcoin.vo.orderbook.OrderbookVo;

public class OrderbookBRMercadoBitcoin extends OrderbookDefault{
	
	private static String NAME = "Mercado Bitcoin";
	private static String LOCATE = "BR";
	private static String URL = "https://www.mercadobitcoin.net/api/#COIN#/orderbook/";
	private String coin;
	
	public OrderbookBRMercadoBitcoin(String coin){
		
		if(coin.equals("BTC")){
			this.coin = "BTC";
		}
		
	}
	
	public OrderbookVo getOrderbook(){
		
		try{
			MercadoBitcoinOrderbookVo mercadoBitcoinOrderbookVo = getRestTemplate().getForObject( URL.replace("#COIN#", coin) , MercadoBitcoinOrderbookVo.class);
			
			OrderbookVo orderbookVo = new OrderbookVo();
			
			List<OrderbookAskVo> orderbookAskVoList = new ArrayList<OrderbookAskVo>();
			List<OrderbookBidVo> orderbookBidVoList = new ArrayList<OrderbookBidVo>();
			
			
			for(int i = 0; i < mercadoBitcoinOrderbookVo.getAsks().length; i++){
				orderbookAskVoList.add( normalizeDataOrderbookAsk(mercadoBitcoinOrderbookVo.getAsks()[i][0] , mercadoBitcoinOrderbookVo.getAsks()[i][1] ) );
			}
			
			for(int i = 0; i < mercadoBitcoinOrderbookVo.getBids().length; i++){
				orderbookBidVoList.add( normalizeDataOrderbookBid(mercadoBitcoinOrderbookVo.getBids()[i][0] , mercadoBitcoinOrderbookVo.getBids()[i][1] ) );
			}
			
			orderbookVo.setOrderbookAsk(orderbookAskVoList);
			orderbookVo.setOrderbookBid(orderbookBidVoList);
			
			return orderbookVo;
		
		}catch (Exception e) {
			return createDefaultObject(NAME, LOCATE, coin);
		}
		
	}
	
	private OrderbookBidVo normalizeDataOrderbookBid(String price, String quantity ){

		OrderbookBidVo orderbookBidVo = new OrderbookBidVo();
		
		orderbookBidVo.setExchange(NAME);
		orderbookBidVo.setLocate(LOCATE);
		orderbookBidVo.setPrice(Double.valueOf(price));
		orderbookBidVo.setQuantity(Double.valueOf(quantity));
		orderbookBidVo.setOrderTotal(orderbookBidVo.getPrice() * orderbookBidVo.getQuantity());
		
		return orderbookBidVo;
	}
	
	
	private OrderbookAskVo normalizeDataOrderbookAsk(String price, String quantity ){

		OrderbookAskVo orderbookAskVo = new OrderbookAskVo();
		
		orderbookAskVo.setExchange(NAME);
		orderbookAskVo.setLocate(LOCATE);
		orderbookAskVo.setPrice(Double.valueOf(price));
		orderbookAskVo.setQuantity(Double.valueOf(quantity));
		orderbookAskVo.setOrderTotal(orderbookAskVo.getPrice() * orderbookAskVo.getQuantity() );
		
		return orderbookAskVo;
	}
}
