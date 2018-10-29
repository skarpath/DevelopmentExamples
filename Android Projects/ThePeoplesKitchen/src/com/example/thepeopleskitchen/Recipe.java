package com.example.thepeopleskitchen;

import java.io.Serializable;

public class Recipe implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8810056217401728086L;

	String recipe_id;
	String title, publisher, image_url,
	recipe_url, publisher_url, source_url;
	
	String rank;

	public String getSource_url() {
		return source_url;
	}

	public void setSource_url(String source_url) {
		this.source_url = source_url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getRecipe_id() {
		return recipe_id;
	}

	public void setRecipe_id(String recipe_id) {
		this.recipe_id = recipe_id;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getRecipe_url() {
		return recipe_url;
	}

	public void setRecipe_url(String recipe_url) {
		this.recipe_url = recipe_url;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getPublisher_url() {
		return publisher_url;
	}

	public void setPublisher_url(String publisher_url) {
		this.publisher_url = publisher_url;
	}

	@Override
	public String toString() {
		return "Recipe [recipe_id=" + recipe_id + ", title=" + title
				+ ", publisher=" + publisher + ", image_url=" + image_url
				+ ", recipe_url=" + recipe_url + ", publisher_url="
				+ publisher_url + ", source_url=" + source_url + ", rank="
				+ rank + ", getSource_url()=" + getSource_url()
				+ ", getTitle()=" + getTitle() + ", getPublisher()="
				+ getPublisher() + ", getRecipe_id()=" + getRecipe_id()
				+ ", getImage_url()=" + getImage_url() + ", getRecipe_url()="
				+ getRecipe_url() + ", getRank()=" + getRank()
				+ ", getPublisher_url()=" + getPublisher_url()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	
	
	
}
