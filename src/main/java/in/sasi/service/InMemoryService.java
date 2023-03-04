package in.sasi.service;

public interface InMemoryService {

	void refreshSystemStatus();
	
	void refreshTickers();

	void refreshTicker(String symbol);
	
}
