package com.example.babydayssqlite;

public class Diaper {
	private int id;
	private String date;
	private String time;
	private String type;
	
	public Diaper(){}
	
	public Diaper(String date, String time, String type){
		super();
		this.date = date;
		this.time = time;
		this.type = type;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setDate(String date){
		this.date = date;
	}
	
	public String getDate(){
		return date;
	}
	
	public void setTime(String time){
		this.time = time;
	}
	
	public String getTime(){
		return time;
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	public String getType(){
		return type;
	}
	
	public String toString() {
        return "Milk [id=" + id + ", date=" + date + ", time=" + time
                + ", type=" + type + "]";
    }
}
