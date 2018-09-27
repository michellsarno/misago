package br.com.misago.bitcoin.service.ticker;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.misago.bitcoin.service.ConnectionApiRestService;
import br.com.misago.bitcoin.vo.TickerVo;

public class TickerDefault extends ConnectionApiRestService {
	
	public TickerVo createDefaultObject(String name, String locate){

		TickerVo tickerVo = new TickerVo();
		
		tickerVo.setExchange(name);
		tickerVo.setLocate(locate);
		tickerVo.setHigh("0");
		tickerVo.setLast("0");
		tickerVo.setLow("0");
		tickerVo.setBuy("0");
		tickerVo.setSell("0");
		tickerVo.setVol("0");
		
		Date date = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		String formattedDate = dateFormat.format(date);
		
		tickerVo.setDate(formattedDate);
		
		
		return tickerVo;
	}

}
