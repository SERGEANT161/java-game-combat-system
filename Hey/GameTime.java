package fightingGame21;

public class GameTime {
	private int totalDays;
	private int dayOfWeek;
	private int timeOfDay;
	
	public GameTime(int totalDays,int dayOfWeek,int timeOfDay) {
		this.totalDays=totalDays;
		this.dayOfWeek=dayOfWeek;
		this.timeOfDay=timeOfDay;
	}
		
	
	public int getTotal() {
		return totalDays;
	}
	
	public String getDay() {
		String day=" ";
		switch(dayOfWeek) {
		case 0:day="Monday";break;
		case 1:day="Tuesday";break;
		case 2:day="Wednesday";break;
		case 3:day="Thursday";break;
		case 4:day="Friday";break;
		case 5:day="Saturday";break;
		case 6:day="Sunday";break;
		}
		return day;
	}
	
	public String getTime() {
		String time=" ";
		switch(timeOfDay) {
		case 0:time="Morning";break;
		case 1:time="Afternoon";break;
		case 2:time="Evening";break;
		}
		return time;
	}
	
	public void setTime(int time) {
		timeOfDay=time;
	}
	
	public void addTotal(){
		totalDays+=1;
		
	}
	
	public void addDay(){
		if(dayOfWeek==6) {
			dayOfWeek=0;
		}else {dayOfWeek+=1;}
		
	}
	
	public void addTime(){
		if(timeOfDay==2) {
			timeOfDay=0;
		}else {timeOfDay+=1;}
		
	}

}
