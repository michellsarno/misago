package br.com.misago.bitcoin.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TickerNegocieCoinsVo {
	
	@JsonProperty("high")
	private String high;
	
	@JsonProperty("low")
	private String low;
	
	@JsonProperty("vol")
	private String vol;
	
	@JsonProperty("last")
	private String last;
	
	@JsonProperty("buy")
	private String buy;
	
	@JsonProperty("sell")
	private String sell;
	
	@JsonProperty("date")
	private int date;
    
    public TickerNegocieCoinsVo(){
	}
	
	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getVol() {
		return vol;
	}

	public void setVol(String vol) {
		this.vol = vol;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getBuy() {
		return buy;
	}

	public void setBuy(String buy) {
		this.buy = buy;
	}

	public String getSell() {
		return sell;
	}

	public void setSell(String sell) {
		this.sell = sell;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Ticker [high=" + high + ", low=" + low + ", vol=" + vol + ", last=" + last + ", buy="
				+ buy + ", sell=" + sell + ", date=" + date + "]";
	}
	
	
}
