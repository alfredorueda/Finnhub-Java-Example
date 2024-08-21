package edu.alfredo.finnhub;

import com.github.oscerd.finnhub.client.FinnhubClient;
import com.github.oscerd.finnhub.models.CompanyProfile2;
import com.github.oscerd.finnhub.models.Exchange;
import com.github.oscerd.finnhub.models.Quote;
import com.github.oscerd.finnhub.models.StockSymbol;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ParseException, InterruptedException {

        // Just testing the Finnhub API Rate Limit in the Free Plan
        // It has worked for 100 requests with a 500ms delay between them pretty well with the Free Plan
        // on 21 of august 2024
        for (int i = 0; i < 100; i++) {

            FinnhubClient client = new FinnhubClient.Builder().token("cr2vqs1r01qkkc01ta30cr2vqs1r01qkkc01ta3g").build();

            CompanyProfile2 companyProfile = client.companyProfile("TSLA");

            System.out.println("companyProfile = " + companyProfile);

            Quote quote = client.quote("TSLA");

            System.out.println("quote = " + quote);

            List<StockSymbol> symbols = client.symbols(Exchange.US_EXCHANGES.toString());

            System.out.println("symbols = " + symbols);

            Thread.sleep(500);

        }

    }
}
