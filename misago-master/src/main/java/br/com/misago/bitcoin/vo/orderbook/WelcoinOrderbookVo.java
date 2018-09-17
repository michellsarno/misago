package br.com.misago.bitcoin.vo.orderbook;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class WelcoinOrderbookVo {
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({
	"ask",
	"bid"
	})

	@JsonProperty("ask")
	private List<WelcoinOrderbookAsk> ask = null;
	
	@JsonProperty("bid")
	private List<WelcoinOrderbookBid> bid = null;
	

	@JsonProperty("ask")
	public List<WelcoinOrderbookAsk> getAsk() {
	return ask;
	}

	@JsonProperty("ask")
	public void setAsk(List<WelcoinOrderbookAsk> ask) {
	this.ask = ask;
	}
	
	@JsonProperty("bid")
	public List<WelcoinOrderbookBid> getBid() {
	return bid;
	}

	@JsonProperty("bid")
	public void setBid(List<WelcoinOrderbookBid> bid) {
	this.bid = bid;
	}


	@Override
	public String toString() {
		return "Welcoin [ask=" + ask + "] - "+" [bid=" + bid + "]";
	}
	
	
	
}
