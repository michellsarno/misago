package br.com.misago.bitcoin.service.orderbook;

import org.springframework.stereotype.Service;

import br.com.misago.bitcoin.vo.orderbook.OrderbookVo;

@Service
public class OrderbookService {

	public OrderbookVo getAllOrderbookAsk(){
		
		OrderbookVo orderbookVo = new OrderbookBRNegocieCoins("BTC").getOrderbook();
		
		OrderbookVo orderbookMercadoBitcoinVo = new OrderbookBRMercadoBitcoin("BTC").getOrderbook();
		orderbookVo.addAllOrderbookAsk(orderbookMercadoBitcoinVo.getOrderbookAsk());
		orderbookVo.addAllOrderbookBid(orderbookMercadoBitcoinVo.getOrderbookBid());
		
		OrderbookVo orderbookWelcoinVo = new OrderbookBRWelcoin("BTC").getOrderbook();
		orderbookVo.addAllOrderbookAsk(orderbookWelcoinVo.getOrderbookAsk());
		orderbookVo.addAllOrderbookBid(orderbookWelcoinVo.getOrderbookBid());
		
		
		OrderbookVo orderbookBrabexVo = new OrderbookBRBrabex("BTC").getOrderbook();
		orderbookVo.addAllOrderbookAsk(orderbookBrabexVo.getOrderbookAsk());
		orderbookVo.addAllOrderbookBid(orderbookBrabexVo.getOrderbookBid());
		
		return orderbookVo;
		
	}
	
	

}
