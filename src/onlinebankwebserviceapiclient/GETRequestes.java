package onlinebankwebserviceapiclient;

import com.mycompany.onlinebankwebserviceapi.model.Account;
import com.mycompany.onlinebankwebserviceapi.model.Customer;
import com.mycompany.onlinebankwebserviceapi.model.Transaction;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class GETRequestes {

//------------------Retruns arraylist of all custoemrs--------------------------
	public ArrayList<Customer> getAllCustomers(){
          String jsonString = performGETRequest("http://localhost:49000/"
                  + "api/customers/"); 
          
          System.out.println(jsonString);
          return new ArrayList<Customer>();
	}
//------------------Retruns customer with a given ID----------------------------
        public Customer getCustomerByID(String id){
          String jsonString = performGETRequest("http://localhost:49000/"
                  + "api/customers/"+id); 
          
          System.out.println(jsonString);
          return new Customer();
	}
//----------Retruns all accounts for a customer with a given ID-----------------
        public ArrayList<Account> getAllAccountsForCustomer(String id){
          String jsonString = performGETRequest("http://localhost:49000/"
                  + "api/customers/"+id+"/accounts"); 
          
          System.out.println(jsonString);
          return new ArrayList<Account>();
	}
//--------Returns account details for account with account number---------------
        public Account getAccountsDetails(int accNumber){
          String jsonString = performGETRequest("http://localhost:49000/api"
                  + "/accounts//"+accNumber); 
          
          System.out.println(jsonString);
          return new Account();
	}  
//-------Returns all transactions in the system for all accounts----------------
        public ArrayList<Transaction> getAllTransactions(){
          String jsonString = performGETRequest("http://localhost:49000/api/"
                  + "transactions/all"); 
          
          System.out.println(jsonString);
          return new ArrayList<Transaction>();
	} 
//-------Returns all transactions in the system for all accounts----------------
        public String makeTransfer(int accFrom, int accTo, double amount){
          String jsonString = performGETRequest("http://localhost:49000/api/"
                  + "transactions/transfer/"+accFrom+"/"+accTo
                  +"/"+amount+""); 
          
          System.out.println(jsonString);
          return "";
	}
//-------Returns all transactions in the system for all accounts----------------
        public ArrayList<Account> getAllAccounts(){
          String jsonString = performGETRequest("http://localhost:49000/api/"
                  + "accounts/all"); 
          
          System.out.println(jsonString);
          return new ArrayList<Account>();
	} 
//-------Returns all transactions in the system for all accounts----------------
        public ArrayList<Transaction> getAllTransactions(int accNumber){
          String jsonString = performGETRequest("http://localhost:49000/api/"
                  + "customers/bob1/accounts/"+accNumber+"/transactions"); 
          
          System.out.println(jsonString);
          return new ArrayList<Transaction>();
	} 
//-------Returns all transactions in the system for all accounts----------------
        public String login(String login, String password){
          String jsonString = performGETRequest("http://localhost:49000/api/"
                  + "customers/"+login+"/"+password+""); 
          
          System.out.println(jsonString);
          return jsonString;
	} 
//-------Returns all transactions in the system for all accounts----------------
        public String getSortCode(){
          String jsonString = performGETRequest("http://localhost:49000/api/"
                  + "accounts/sortcode"); 
          
          System.out.println(jsonString);
          return jsonString;
	} 
//-------Returns all transactions in the system for all accounts----------------
        public String getBalance(String login){
          String jsonString = performGETRequest("http://localhost:49000/api/accounts"
                  + "/total/"+login+""); 
          
          System.out.println(jsonString);
          return jsonString;
	}         
//----------------Method used for GET requests----------------------------------
    public String performGETRequest(String URL){
        String output="";  
	  try {
		URL url = new URL(URL);
		HttpURLConnection conn = (HttpURLConnection) 
                        url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
                conn.getResponseCode();

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));
                //all replies consist of one line only
		output = br.readLine();
		conn.disconnect();

	  } catch (MalformedURLException e) {
		e.printStackTrace();
	  } catch (IOException e) {
		e.printStackTrace();
	  }
          return output;
    }
}