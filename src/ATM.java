import java.util.Scanner;

public class ATM{

    Account acc1;
    Account acc2;
    Account acc3;
    

    public ATM(){
        System.out.println("Welcome to Bank of Imagination");
        acc1 = new Account(1,"JohnSmith",100,1234);
        
        acc2 = new Account(2,"MaggieSmith",1000,5678);
        acc3 = new Account(3,"Bo burnham",345,2345);
        Scanner scan = new Scanner(System.in);
        
        
        
        boolean stop = false;
        
        do {
        	int acct = 0;
            int p = 0;
            System.out.println("Welcome to the ATM! Please enter Account number: ");
            acct = scan.nextInt();
        
            if(acc1.getAcctno() != acct && acc2.getAcctno() != acct && acc3.getAcctno() != acct){
            	//Also bad security
            	System.out.println("No such account in records");
            	System.out.println("Do you want to quit? (y/n)");
        		String temp = scan.next();
            	if(temp.equals("y")){

            		break;
            		
        		}
        		else{
        			continue;
        		}
        	
            }
            
            
            
            System.out.println("Please enter pin: ");
            p = scan.nextInt();
            int len = (int)(Math.log10(p)+1);
            
            
            //better to use arraylist of accounts. For purposes of this example it is hardcoded with lots of repetitive coding
            Account user;
            
            if(acc1.getAcctno() == acct){
            	if(acc1.lockOut()){
            		System.out.println("This account is locked");
            		System.out.println("Do you want to quit? (y/n)");
            		String temp = scan.next();
                	if(temp.equals("y")){

                		break;
                		
            		}
            		else{
            			continue;
            		}
            	}
            	if(len != 4 || p != acc1.getPin()){
            		acc1.setAttempts((acc1.getAttempts() + 1));
            		System.out.println("Incorrect Pin!");
            		continue;
            	}
            	else{
            		user = acc1;
            	}
            }
            else if(acc2.getAcctno() == acct){
            	if(acc2.lockOut()){
            		System.out.println("This account is locked");
            		System.out.println("Do you want to quit? (y/n)");
            		String temp = scan.next();
                	if(temp.equals("y")){

                		break;
                		
            		}
            		else{
            			continue;
            		}
            	}
            	if(len != 4 || p != acc2.getPin()){
            		acc2.setAttempts((acc2.getAttempts() + 1));
            		System.out.println("Incorrect Pin!");
            		continue;
            	}
            	else{
            		user = acc2;
            	}
            	
            }
            else if(acc3.getAcctno() == acct){
            	if(acc3.lockOut()){
            		System.out.println("This account is locked");
            		System.out.println("Do you want to quit? (y/n)");
            		String temp = scan.next();
                	if(temp.equals("y")){

                		break;
                		
            		}
            		else{
            			continue;
            		}
            	}
            	if(len != 4 || p != acc3.getPin()){
            		acc3.setAttempts((acc3.getAttempts() + 1));
            		System.out.println("Incorrect Pin!");
            		continue;
            		
            	}
            	else{
            		user = acc3;
            	}
            }
            else{
            	System.out.println("Do you want to quit? (y/n)");
        		String temp = scan.next();
            	if(temp.equals("y")){

            		break;
            		
        		}
        		else{
        			continue;
        		}
            }
            
            int option = 0;
            System.out.println("Welcome, what would you like to do? 1) Deposit, 2) Withdraw, 3) Balance");
            option = scan.nextInt();
        
            switch(option){
            	case 1: System.out.print("Input amount to Deposit: ");
            			double l = scan.nextDouble();
            			user.deposit(l);
            			break;
            	case 2: System.out.println("Input amount to Withdraw: ");
            			double m = scan.nextDouble();
            			user.withdraw(m);
            			break;
            	case 3: System.out.println("Your account balance is: " + user.getBalance());
            			break;
            	default:
            			System.out.println("System error has occured");
            }
            
            System.out.println("Do you want to quit? (y/n)");
    		String temp = scan.next();
        	if(temp.equals("y")){

        		break;
        		
    		}
    		else{
    			continue;
    		}
            
        }while(!stop);
        
    }



}

