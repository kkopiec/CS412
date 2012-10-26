import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class OurSearchFiles {
	private IndexSearcher searcher = null;
	private QueryParser parser = null;

	/** Creates a new instance of SearchEngine */
	public OurSearchFiles() throws IOException {
		Directory dir = FSDirectory.open(new File("./indexes"));
		searcher = new IndexSearcher(dir);
		parser = new QueryParser(Version.LUCENE_CURRENT, "text",
				new StandardAnalyzer(Version.LUCENE_CURRENT));
	}

//	public Hits performSearch(String queryString) throws IOException,
//			ParseException {
//		Query query = parser.parse(queryString);
//		Hits hits = searcher.search(query);
//		return hits;
//	}
}