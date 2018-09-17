package br.com.misago.bitcoin.vo.orderbook;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class WelcoinOrderbookAsk {
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({
	"price",
	"quantity",
	"user"
	})

	@JsonProperty("id")
	private String id;
	@JsonProperty("price")
	private Double price;
	@JsonProperty("quantity")
	private Double quantity;
	@JsonProperty("user")
	private String user;

	@JsonProperty("price")
	public Double getPrice() {
	return price;
	}

	@JsonProperty("price")
	public void setPrice(Double price) {
	this.price = price;
	}

	@JsonProperty("quantity")
	public Double getQuantity() {
	return quantity;
	}

	@JsonProperty("quantity")
	public void setQuantity(Double quantity) {
	this.quantity = quantity;
	}

	@JsonProperty("user")
	public String getUser() {
	return user;
	}

	@JsonProperty("user")
	public void setUser(String user) {
	this.user = user;
	}

	@Override
	public String toString() {
		return "Ask [id=" + id + ", price=" + price + ", quantity=" + quantity + ", user=" + user + "]";
	}

}
