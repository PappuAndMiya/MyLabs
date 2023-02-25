<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<ul>
<li><b>Application Server Time:</b>${appServerTime}</li>
<li><b>General Service - Platform Ping:</b> ${platformPing}</li>
<li><b>General Service - Platform Time:</b> ${platformTime}</li>
<li><b>General Service - Platform Status:</b> ${platformStatus}</li>
<li><b>General Service - Platform Info:</b> ${fn:length(platformInfo.symbols)}</li>
<li><b>Public Service - Tickers:</b> ${fn:length(tickers)}</li>
<li><b>Public Service - Tickers By Quote Asset [INR]:</b> ${fn:length(tickersByQuoteAsset)}</li>
<li><b>Public Service - Ticker [BTC-INR]:</b> [${ticker.lastPrice}] - [${ticker.openPrice}] - [${ticker.change24Hrs}]</li>
</ul>


<c:forEach items="${tickersByQuoteAsset}" var="ticker">
	${ticker.symbol}; ${ticker.change24Hrs}<br>
</c:forEach>