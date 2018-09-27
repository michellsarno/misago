package br.com.misago.bitcoin.service.ticker;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.misago.bitcoin.vo.TickerVo;

@Service
public class TickerService {

	public List<TickerVo> getAllTicker(){
		
		List<TickerVo> listTicker = new ArrayList<TickerVo>();
		
		listTicker.add( new TickerBRMercadoBitCoin("BTC").getTicker() );
		listTicker.add( new TickerBRNegocieCoins("BTC").getTicker() );
		
		return listTicker;
		
	}
	
	

}
