package fr.dauphine.lamsade.hib.predictions.objects;

public class WebSite {

	private long id;
	private String Website_Name;
	private String Website_URL;

	public WebSite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getWebsite_Name() {
		return Website_Name;
	}

	public void setWebsite_Name(String website_Name) {
		Website_Name = website_Name;
	}

	public String getWebsite_URL() {
		return Website_URL;
	}

	public void setWebsite_URL(String website_URL) {
		Website_URL = website_URL;
	}

}
