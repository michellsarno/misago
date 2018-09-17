package br.com.misago.bitcoin.vo.orderbook;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class BrabexOrderbookVo {
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({
	"pair",
	"bids",
	"asks"
	})
	
	@JsonProperty("pair")
	private String pair;

	@JsonProperty("pair")
	public String getPair() {
		return pair;
	}

	@JsonProperty("pair")
	public void setPair(String pair) {
		this.pair = pair;
	}

	@JsonProperty("asks")
	private String[][] asks;
	
	@JsonProperty("bids")
	private String[][] bids;
	
	@JsonProperty("asks")
	public String[][] getAsks(){
		return asks;
	}
	
	@JsonProperty("asks")
    public void setAsks(String[][] asks){
    	this.asks = asks;
    }
	
	@JsonProperty("bids")
	public String[][] getBids(){
		return bids;
	}
	
	@JsonProperty("bids")
    public void setBids(String[][] bids){
    	this.bids = bids;
    }

	@Override
	public String toString() {
		return "MercadoBitcoinOrderbookVo [asks=" + Arrays.toString(asks) + ", bids=" + Arrays.toString(bids) + "]";
	}
	
	
}
