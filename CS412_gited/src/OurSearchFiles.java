package lucene.demo.search;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lucene.demo.business.Hotel;
import lucene.demo.business.HotelDatabase;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;

public class SearchEngine {
  private IndexSearcher searcher = null;
  private QueryParser parser = null;

  /** Creates a new instance of SearchEngine */
  public SearchEngine() throws IOException {
    searcher = new IndexSearcher("index-directory");
    parser = new QueryParser("content", new StandardAnalyzer());
  }

  public Hits performSearch(String queryString) 
  throws IOException, ParseException {
    Query query = parser.parse(queryString);
    Hits hits = searcher.search(query);
    return hits;
  }
}