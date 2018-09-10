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
		
		return orderbookVo;
		
	}
	
	

}
