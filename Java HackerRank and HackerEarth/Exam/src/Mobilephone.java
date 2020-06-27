public class Mobilephone {

    private String company;
    private String model;
    private int cost;
    private int memCapacity;
    private int screenSize;
    private int FCres;
    private int RCres;

  
    public Mobilephone(){
        this.company = "iPhone";
        this.model = "11 Pro";
    }
    public Mobilephone(int cost,int memCapacity){
        this.cost = 75000;
        this.memCapacity = 8;
    }
    
    public Mobilephone(int screenSize, int FCres, int RCres){
        this.screenSize = 1024;
        this.FCres = 24;
        this.RCres = 48;
    }
   
   public String getDetails() {
		return company + " " + model;
	}
	
   public String getValues() {
		return cost + " " + memCapacity;
	}
   
   public String getSizes() {
	   return screenSize + " " + FCres + " " + RCres;
   }
	
	public static void main(String args[]){
    	Mobilephone mp = new Mobilephone();
    	Mobilephone mp1 = new Mobilephone(75000, 8);
    	Mobilephone mp2 = new Mobilephone(2048, 24, 48);
    	
        System.out.println( mp.getDetails());
        
        System.out.println(mp1.getValues());
        
        System.out.println(mp2.getSizes());
        
    }
}


