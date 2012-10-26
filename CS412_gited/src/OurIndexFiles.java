import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;


public class OurIndexFiles{
	GZReader parser = new GZReader();
	 IndexWriter writer;
	public OurIndexFiles() {
		Directory dir;
		try {
			dir = FSDirectory.open(new File("./indexes"));
			Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_CURRENT);
			IndexWriterConfig iwc = new IndexWriterConfig(Version.LUCENE_CURRENT, analyzer);
			iwc.setOpenMode(OpenMode.CREATE_OR_APPEND);
			  writer = new IndexWriter(dir, iwc);
			  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

public void indexArticle() throws IOException
{
	
	ArrayList<PDocument> articles = parser.parse("Support/DataFiles/");
	
	for (PDocument artical: articles)
	{
		System.out.println("indexing article");
	Document doc = new Document();
	doc.add(new Field("docNo", artical.getDocNo(), Field.Store.YES,Index.ANALYZED));
	doc.add(new Field("archive", artical.getArchive(), Field.Store.YES,Index.ANALYZED));
	doc.add(new Field("profile", artical.getProfile(), Field.Store.YES,Index.ANALYZED));
	doc.add(new Field("date", artical.getDate(), Field.Store.YES,Index.ANALYZED));
	doc.add(new Field("headline", artical.getHeadline(), Field.Store.YES,Index.ANALYZED));
	doc.add(new Field("byline", artical.getByline(), Field.Store.YES,Index.ANALYZED));
	doc.add(new Field("dateline", artical.getDateline(), Field.Store.YES,Index.ANALYZED));
	doc.add(new Field("text", artical.getText(), Field.Store.YES, Field.Index.ANALYZED));
	doc.add(new Field("pub", artical.getPub(), Field.Store.YES, Field.Index.ANALYZED));
	doc.add(new Field("page", artical.getPage(), Field.Store.YES, Field.Index.ANALYZED));

	writer.addDocument(doc);
	}
	writer.close();
	
}


}