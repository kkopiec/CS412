public void indexFiles() throws IOException
{
	IndexWriter iw = new IndexWriter(dir, new StandardAnalyzer(), true);

	Document doc = new Document();
	doc.add(new Field("docNo", PDocument.getDocNo(), Field.Store.YES, Field.Index.TOKENIZED));
	doc.add(new Field("archive", PDocument.getArchive(), Field.Store.YES, Field.Index.TOKENIZED));
	doc.add(new Field("profile", PDocument.getProfile(), Field.Store.YES, Field.Index.TOKENIZED));
	doc.add(new Field("date", PDocument.getDate(), Field.Store.YES, Field.Index.TOKENIZED));
	doc.add(new Field("headline", PDocument.getHeadline(), Field.Store.YES, Field.Index.TOKENIZED));
	doc.add(new Field("byline", PDocument.getByline(), Field.Store.YES, Field.Index.TOKENIZED));
	doc.add(new Field("dateline", PDocument.getDateline(), Field.Store.YES, Field.Index.TOKENIZED));
	doc.add(new Field("text", PDocument.getText(), Field.Store.YES, Field.Index.TOKENIZED));
	doc.add(new Field("pub", PDocument.getPub(), Field.Store.YES, Field.Index.TOKENIZED));
	doc.add(new Field("page", PDocument.getPage(), Field.Store.YES, Field.Index.TOKENIZED));

	iw.addDocument(doc);
}
public void rebuildIndexes() throws IOException {
   //
   // Erase existing index
   //
   getIndexWriter(true);
   //
   // Index all hotel entries
   //
   PDocument[] articles = Parcer.getHotels();
   for(pDocument artical: articals) {
     indexHotel(artical);
   }
   //
   // Don't forget to close the index writer when done
   //
   closeIndexWriter();
 }