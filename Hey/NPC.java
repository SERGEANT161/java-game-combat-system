package fightingGame21;

public abstract class NPC extends Character{
	private int trust;
	private int respect;
	private int attachment;
	private int loyalty;
	private int fatigue;
	private int mood;
	private boolean exist=false;
	
	public NPC(String name,int HP,int MP,int Power,int TS,int trust,int respect,int attachment,int loyalty,int fatigue,int mood,boolean exist) {
		super(name,HP,MP,Power,TS);
		this.trust=trust;
		this.respect=respect;
		this.attachment=attachment;
		this.loyalty=loyalty;
		this.fatigue=fatigue;
		this.mood=mood;
		this.exist=exist;
	}
	
	public int getTrust() {
		return trust;
	}
	
	public int getRespect() {
		return respect;
	}
	
	public int getAttachment() {
		return attachment;
	}
	
	public int getLoyalty() {
		return loyalty;
	}
	
	public int getFatigue() {
		return fatigue;
	}
	
	public int getMood() {
		return mood;
	}
	
	public boolean getExist() {
	    return exist;
	}
	
	public void setTrust(int trust) {
		this.trust=trust;
	}
	
	public void setRespect(int respect) {
		this.respect=respect;
	}
	
	public void setAttachment(int attachment) {
		this.attachment=attachment;
	}
	
	public void setLoyalty(int loyalty) {
		this.loyalty=loyalty;
	}
	
	public void setFatigue(int fatigue) {
		this.fatigue=fatigue;
	}
	
	public void setMood(int mood) {
		this.mood=mood;
	}
	
	public void setExist(boolean exist) {
	    this.exist=exist;
	}
	
	public void gainTrustMin() {
		trust+=1;
	}
	
	public void gainRespectMin() {
		respect+=1;
	}
	
	public void gainAttachmentMin() {
		attachment+=1;
	}
	
	public void gainLoyaltyMin() {
		loyalty+=1;
	}
	
	public void gainFatigueMin() {
		fatigue+=1;
	}
	
	public void gainMoodMin() {
		mood+=1;
	}
	
	public void gainTrustMax() {
		trust+=5;
	}
	
	public void gainRespectMax() {
		respect+=5;
	}
	
	public void gainAttachmentMax() {
		attachment+=5;
	}
	
	public void gainLoyaltyMax() {
		loyalty+=5;
	}
	
	public void gainFatigueMax() {
		fatigue+=5;
	}
	
	public void gainMoodMax() {
		mood+=5;
	}
	
	public void loseTrustMin() {
		trust-=1;
	}
	
	public void loseRespectMin() {
		respect-=1;
	}
	
	public void loseAttachmentMin() {
		attachment-=1;
	}
	
	public void loseLoyaltyMin() {
		loyalty-=1;
	}
	
	public void loseFatigueMin() {
		fatigue-=1;
	}
	
	public void loseMoodMin() {
		mood-=1;
	}
	
	public void loseTrustMax() {
		trust-=5;
	}
	
	public void loseRespectMax() {
		respect-=5;
	}
	
	public void loseAttachmentMax() {
		attachment-=5;
	}
	
	public void loseLoyaltyMax() {
		loyalty-=5;
	}
	
	public void loseFatigueMax() {
		fatigue-=5;
	}
	
	public void loseMoodMax() {
		mood-=5;
	}
	
	public abstract String[] getWork();
	public abstract String[] getRest();
	public abstract String[] getEntertainment1();
	public abstract String[] getEntertainment2();
	public abstract String getCharacterProfile();
}

