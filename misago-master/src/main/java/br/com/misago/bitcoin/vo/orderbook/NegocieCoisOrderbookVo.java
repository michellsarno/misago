package br.com.misago.bitcoin.vo.orderbook;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class NegocieCoisOrderbookVo {
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({
	"ask",
	"bid"
	})

	@JsonProperty("ask")
	private List<NegocieCoinsOrderbookAsk> ask = null;
	
	@JsonProperty("bid")
	private List<NegocieCoinsOrderbookBid> bid = null;
	

	@JsonProperty("ask")
	public List<NegocieCoinsOrderbookAsk> getAsk() {
	return ask;
	}

	@JsonProperty("ask")
	public void setAsk(List<NegocieCoinsOrderbookAsk> ask) {
	this.ask = ask;
	}
	
	@JsonProperty("bid")
	public List<NegocieCoinsOrderbookBid> getBid() {
	return bid;
	}

	@JsonProperty("bid")
	public void setBid(List<NegocieCoinsOrderbookBid> bid) {
	this.bid = bid;
	}


	@Override
	public String toString() {
		return "NegocieCoisOrderbookAskVo [ask=" + ask + "] - "+" [bid=" + bid + "]";
	}
	
	
}
