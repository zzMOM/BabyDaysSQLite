package com.example.babydayssqlite;

public class Milk {
	private int id;
	private String date;
	private String time;
	private int oz;
	
	public Milk(){}
	
	public Milk(String date, String time, int oz){
		super();
		this.date = date;
		this.time = time;
		this.oz = oz;
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
	
	public void setOZ(int oz){
		this.oz = oz;
	}
	
	public int getOZ(){
		return oz;
	}
	
	public String toString() {
        return "Milk [id=" + id + ", date=" + date + ", time=" + time
                + ", oz=" + oz + "]";
    }
}
