import org.xml.sax.helpers.DefaultHandler;

public class PDocument {
	private String docNo;
	private String archive; // path to gz file
	private String profile;
	private String date;
	private String headline;
	private String byline;
	private String dateline;
	private String text;
	private String pub;
	private String page;

	public PDocument(String currentGzFileName) {
		archive = currentGzFileName;
	}

	/**
	 * @return the docNo
	 */
	public String getDocNo() {
		return docNo;
	}

	/**
	 * @param docNo
	 *            the docNo to set
	 */
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	/**
	 * @return the archive
	 */
	public String getArchive() {
		return archive;
	}

	/**
	 * @param archive
	 *            the archive to set
	 */
	public void setArchive(String archive) {
		this.archive = archive;
	}

	/**
	 * @return the profile
	 */
	public String getProfile() {
		return profile;
	}

	/**
	 * @param profile
	 *            the profile to set
	 */
	public void setProfile(String profile) {
		this.profile = profile;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the headline
	 */
	public String getHeadline() {
		return headline;
	}

	/**
	 * @param headline
	 *            the headline to set
	 */
	public void setHeadline(String headline) {
		this.headline = headline;
	}

	/**
	 * @return the byline
	 */
	public String getByline() {
		return byline;
	}

	/**
	 * @param byline
	 *            the byline to set
	 */
	public void setByline(String byline) {
		this.byline = byline;
	}

	/**
	 * @return the dateline
	 */
	public String getDateline() {
		return dateline;
	}

	/**
	 * @param dateline
	 *            the dateline to set
	 */
	public void setDateline(String dateline) {
		this.dateline = dateline;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the pub
	 */
	public String getPub() {
		return pub;
	}

	/**
	 * @param pub
	 *            the pub to set
	 */
	public void setPub(String pub) {
		this.pub = pub;
	}

	/**
	 * @return the page
	 */
	public String getPage() {
		return page;
	}

	/**
	 * @param page
	 *            the page to set
	 */
	public void setPage(String page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return getDocNo();
	}
}
