package com.dtunctuncer.todoist.api.response;

import com.google.gson.annotations.SerializedName;

public class ProjectResponse{

	@SerializedName("comment_count")
	private int commentCount;

	@SerializedName("indent")
	private int indent;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private long id;

	@SerializedName("order")
	private int order;

	public void setCommentCount(int commentCount){
		this.commentCount = commentCount;
	}

	public int getCommentCount(){
		return commentCount;
	}

	public void setIndent(int indent){
		this.indent = indent;
	}

	public int getIndent(){
		return indent;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(long id){
		this.id = id;
	}

	public long getId(){
		return id;
	}

	public void setOrder(int order){
		this.order = order;
	}

	public int getOrder(){
		return order;
	}

	@Override
 	public String toString(){
		return 
			"ProjectResponse{" + 
			"comment_count = '" + commentCount + '\'' + 
			",indent = '" + indent + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",order = '" + order + '\'' + 
			"}";
		}
}