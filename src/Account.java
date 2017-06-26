public class Account {
    private int acctno;
    private String username;
    private double balance;
    private int pin;
    private int attempts;
    
    public Account(){
        this.balance = 0;
        this.attempts = 0;
    }
    
    public Account(int num, String name, double bal,int p){
        this.attempts = 0;
        this.acctno = num;
        this.username = name;
        this.balance = bal;
        this.pin = p;
    }
    
    public void deposit(double amt){
        if(amt >= 0){
            //possible abuse?
            this.balance += amt;
        }
        else{
        	System.out.println("Can't deposit that amount");
        }
    
    }
    
    public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	/*
     * VERY BAD SECURITY DO NOT DO THIS
     */
    public int getPin() {
		return pin;
	}

	
	public void withdraw(double amt){
        if(amt>= 0 && amt <= balance){
            this.balance -= amt;
        
        }
        else{
        	System.out.println("Insufficient Funds");
        }
    
    }
    
    public boolean lockOut(){
        if (attempts >=3){
            return true;
        }
        else{
            return false;
        }
    }

    public double getBalance() {
		return balance;
	}

	/*
     * BAD SECURITY DO NOT DO THIS
     * 
     */
	public int getAcctno() {
		return acctno;
	}



}


