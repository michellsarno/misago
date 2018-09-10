package br.com.misago.bitcoin.vo.orderbook;

import java.util.ArrayList;
import java.util.List;

public class OrderbookVo {
	
	private List<OrderbookAskVo> orderbookAsk;
	private List<OrderbookBidVo> orderbookBid;
	
	public List<OrderbookAskVo> getOrderbookAsk() {
		return orderbookAsk;
	}
	public void setOrderbookAsk(List<OrderbookAskVo> orderbookAsk) {
		this.orderbookAsk = orderbookAsk;
	}
	public List<OrderbookBidVo> getOrderbookBid() {
		return orderbookBid;
	}
	public void setOrderbookBid(List<OrderbookBidVo> orderbookBid) {
		this.orderbookBid = orderbookBid;
	}
	
	public void addAllOrderbookAsk(List<OrderbookAskVo> orderbookAsk) {
		
		if(this.orderbookAsk == null){
			this.orderbookAsk = new ArrayList<>();
		}
		
		this.orderbookAsk.addAll( orderbookAsk );
	}
	
	public void addAllOrderbookBid(List<OrderbookBidVo> orderbookBid) {
		
		if(this.orderbookBid == null){
			this.orderbookBid = new ArrayList<>();
		}
		
		this.orderbookBid.addAll(orderbookBid);
	}
	
	
}
