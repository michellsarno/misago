package br.com.misago.bitcoin.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TickerMercadoBitCoinVo {
	
	@JsonProperty("ticker")
	private TickerMercadoBitCoinVoValues ticker;
	
	public TickerMercadoBitCoinVo(){
	}
    
	public TickerMercadoBitCoinVoValues getTicker() {
		return ticker;
	}
	public void setTicker(TickerMercadoBitCoinVoValues ticker) {
		this.ticker = ticker;
	}
	
	@Override
	public String toString() {
		return "TickerMercadoBitCoinVo [ticker=" + ticker + "]";
	}
	
}
