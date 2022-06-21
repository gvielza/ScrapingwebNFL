package scrapingweb.entity;

public class Player {
private String name;
private String PassYds;
private String YdsAtt;
private String Att;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassYds() {
	return PassYds;
}
public void setPassYds(String passYds) {
	PassYds = passYds;
}
public String getYdsAtt() {
	return YdsAtt;
}
public void setYdsAtt(String ydsAtt) {
	YdsAtt = ydsAtt;
}
public String getAtt() {
	return Att;
}
public void setAtt(String att) {
	Att = att;
}
public Player(String name, String passYds, String ydsAtt, String att) {
	
	this.name = name;
	PassYds = passYds;
	YdsAtt = ydsAtt;
	Att = att;
}

}
