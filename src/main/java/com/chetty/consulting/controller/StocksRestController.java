package com.chetty.consulting.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chetty.consulting.model.Stock;

@RestController
public class StocksRestController {
	@GetMapping("/")
	public String root() {
		return "Please use /StockScreenerSvc/stocks";
	}
	
	@GetMapping("/stocks")
	public List<Stock> getAllDistinctStocks() {
		// get models from wallstreetmojo.com dheeraj vaidya
		// http://www.wallstreetmojo.com/equity-research/
		
		
		String stocksFile = "C:/Users/Veerichetty/Projects/data/sp500hst.txt";

		List<Stock> stockList = new ArrayList<>();
		
		try (Stream<String> stream = Files.lines(Paths.get(stocksFile))) {
			
			stockList = stream.parallel()
							.map(line -> line.split(",", 7))
							.map(array -> new Stock(array[0], array[1], array[2], array[3], array[4], array[5], array[6]))
							.filter(distinctByTicker(s -> s.getTicker()))
							.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return stockList;
	}
	
	@GetMapping("/stocks/count")
	public long getStocksCount() {
		String stocksFile = "C:/Users/Veerichetty/Projects/data/sp500hst.txt";

		long stockCount = 0;
		
		try (Stream<String> stream = Files.lines(Paths.get(stocksFile))) {
			
			stockCount = stream
							.parallel()
							.count();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return stockCount;
	}

	public static <T> Predicate<T> distinctByTicker(Function<? super T, ?> keyExtractor) {
	    Map<Object,Boolean> seen = new ConcurrentHashMap<>();
	    return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}
}
