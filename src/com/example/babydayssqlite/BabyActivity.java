package com.example.babydayssqlite;

public class BabyActivity {
	private int id;
	private String date;
	private String time;
	private String type;
	private String info;
	
	public BabyActivity(){}
	
	public BabyActivity(String date, String time, String type, String info){
		super();
		this.date = date;
		this.time = time;
		this.type = type;
		this.info = info;
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
	
	public void setInfo(String info){
		this.info = info;
	}
	
	public String getInfo(){
		return info;
	}
	
	public String toString() {
        return "BabyActivity [id=" + id + ", date=" + date + ", time=" + time
                + ", type=" + type + ", info=" + info + "]";
    }
}
