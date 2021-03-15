package pizza.pojo;

public class Pizza
{
     private int id;
     private String name,category,description,sprice,mprice,lprice;
     private String image;
      
     public Pizza()
     {
    	 
     }
     
     

	public Pizza(String name, String category, String description, String sprice, String mprice, String lprice,
			String image) {
		super();
		this.name = name;
		this.category = category;
		this.description = description;
		this.sprice = sprice;
		this.mprice = mprice;
		this.lprice = lprice;
		this.image = image;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSprice() {
		return sprice;
	}

	public void setSprice(String sprice) {
		this.sprice = sprice;
	}

	public String getMprice() {
		return mprice;
	}

	public void setMprice(String mprice) {
		this.mprice = mprice;
	}

	public String getLprice() {
		return lprice;
	}

	public void setLprice(String lprice) {
		this.lprice = lprice;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
     
	 
}
