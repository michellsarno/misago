package br.com.misago.bitcoin.service.ticker;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.misago.bitcoin.service.ConnectionApiRestService;
import br.com.misago.bitcoin.vo.TickerNegocieCoinsVo;
import br.com.misago.bitcoin.vo.TickerVo;

public class TickerBRNegocieCoins extends ConnectionApiRestService{
	
	private static String NAME = "NegocieCoins";
	private static String LOCATE = "BR";
	private static String URL_TICKER = "https://broker.negociecoins.com.br/api/v3/#COIN#/ticker";
	
	private String coin;
	
	public TickerBRNegocieCoins(String coin){
		
		if(coin.equals("BTC")){
			this.coin = "btcbrl";
		}
		
	}
	
	public TickerVo getTicker(){
		
		TickerNegocieCoinsVo tickerVo = getRestTemplate().getForObject( URL_TICKER.replace("#COIN#", coin) , TickerNegocieCoinsVo.class);
	
		return normalizeDataTickerMercadoBitCoin(tickerVo);
		
	}
	
	
	private TickerVo normalizeDataTickerMercadoBitCoin( TickerNegocieCoinsVo tickerNegocieCoinsVo){

		TickerVo tickerVo = new TickerVo();
		
		tickerVo.setExchange(NAME);
		tickerVo.setLocate(LOCATE);
		tickerVo.setHigh(String.valueOf(tickerNegocieCoinsVo.getHigh()));
		tickerVo.setLast(String.valueOf(tickerNegocieCoinsVo.getLast()));
		tickerVo.setLow(String.valueOf(tickerNegocieCoinsVo.getLow()));
		tickerVo.setBuy(String.valueOf(tickerNegocieCoinsVo.getBuy()));
		tickerVo.setSell(String.valueOf(tickerNegocieCoinsVo.getSell()));
		tickerVo.setVol(String.valueOf(tickerNegocieCoinsVo.getVol()));
		
		
		Date date = new Date(tickerNegocieCoinsVo.getDate()*1000L); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		String formattedDate = dateFormat.format(date);
		
		tickerVo.setDate(formattedDate);
		
		
		return tickerVo;
	}

}
