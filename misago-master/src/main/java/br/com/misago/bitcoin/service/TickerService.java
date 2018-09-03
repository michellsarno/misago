package br.com.misago.bitcoin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.misago.bitcoin.vo.TickerVo;

@Service
public class TickerService {

	public List<TickerVo> getAllTicker(){
		
		List<TickerVo> listTicker = new ArrayList<TickerVo>();
		
		TickerVo tickerVo = new TickerVo();
		
		tickerVo.setLocate("CN");
		tickerVo.setExchange("Exemplo");
		tickerVo.setBuy("100,00");
		tickerVo.setSell("110,00");
		tickerVo.setHigh("120,00");
		tickerVo.setLow("90,00");
		tickerVo.setVol("500,00");
		tickerVo.setLast("115,00");
		tickerVo.setDate("2018-08-12");
		
		listTicker.add(tickerVo);
		
		
		listTicker.add( new TickerBRMercadoBitCoin("BTC").getTicker() );
		listTicker.add( new TickerBRNegocieCoins("BTC").getTicker() );
		
		
		
		
		return listTicker;
		
	}
	
	

}
