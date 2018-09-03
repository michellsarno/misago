package br.com.misago.bitcoin.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.misago.bitcoin.vo.TickerMercadoBitCoinVo;
import br.com.misago.bitcoin.vo.TickerVo;

public class TickerBRMercadoBitCoin extends TickerConnectionService{
	
	private static String NAME = "Mercado Bitcoin";
	private static String LOCATE = "BR";
	private static String URL_TICKER = "https://www.mercadobitcoin.net/api/#COIN#/ticker/";
	
	private String coin;
	
	public TickerBRMercadoBitCoin(String coin){
		
		if(coin.equals("BTC")){
			this.coin = coin;
		}
		
	}
	
	public TickerVo getTicker(){
		
		TickerMercadoBitCoinVo tickerVo = getRestTemplate().getForObject( URL_TICKER.replace("#COIN#", coin) , TickerMercadoBitCoinVo.class);
		
//		ResponseEntity<String> response = restTemplate.getForEntity("https://www.mercadobitcoin.net/api/BTC/ticker/", String.class);
//		
//		System.out.println("response...: "+response.toString());
//		
//		System.out.println(tickerVo.toString());
		
		return normalizeDataTickerMercadoBitCoin(tickerVo);
		
		
	}
	
	
	private TickerVo normalizeDataTickerMercadoBitCoin( TickerMercadoBitCoinVo tickerBRMercadoBitCoinVo){

		TickerVo tickerVo = new TickerVo();
		
		
		tickerVo.setExchange(NAME);
		tickerVo.setLocate(LOCATE);
		tickerVo.setHigh(String.valueOf(tickerBRMercadoBitCoinVo.getTicker().getHigh()));
		tickerVo.setLast(String.valueOf(tickerBRMercadoBitCoinVo.getTicker().getLast()));
		tickerVo.setLow(String.valueOf(tickerBRMercadoBitCoinVo.getTicker().getLow()));
		tickerVo.setBuy(String.valueOf(tickerBRMercadoBitCoinVo.getTicker().getBuy()));
		tickerVo.setSell(String.valueOf(tickerBRMercadoBitCoinVo.getTicker().getSell()));
		tickerVo.setVol(String.valueOf(tickerBRMercadoBitCoinVo.getTicker().getVol()));
		
		
		Date date = new Date(tickerBRMercadoBitCoinVo.getTicker().getDate()*1000L); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		String formattedDate = dateFormat.format(date);
		
		tickerVo.setDate(formattedDate);
		
		
		return tickerVo;
	}
	
}
