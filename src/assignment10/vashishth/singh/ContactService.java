package assignment10.vashishth.singh;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ContactService {
	
	// 1
	public void addContact(Contact contact,List<Contact> contacts) {
		contacts.add(contact);
	}
	
	// 2
	public void removeContact(Contact contact, List<Contact> contacts) throws ContactNotFoundException{
		int flag=0;
		for(Contact cont:contacts) {
			if(cont.equals(contact)) {
				contacts.remove(contact);
				flag=1;
				break;
			}
		}
		if(flag==0) {
			throw new ContactNotFoundException();
		}
	}
	
	// 3
	public Contact searchContactByName(String name, List<Contact> contacts) throws ContactNotFoundException{
		for(Contact contact:contacts) {
			if(contact.getContactName().equals(name)) {
				return contact;
			}
		}
		throw new ContactNotFoundException();
	}
	
	// 4
	List<Contact> SearchContactByNumber(String number, List<Contact> contacts) throws ContactNotFoundException{
		List<Contact> contactList=new ArrayList<Contact>();
		int i=0;
		for(Contact cont:contacts) {
			for(String contactNum: cont.getContactNumber()) {
				if(contactNum.contains(number)) {
					contactList.add(cont);
					break;
				}
			}
		}
		if(contactList.size()==0) {
			throw new ContactNotFoundException();
		}
		return contactList;
	}
	
	// 5
	public void addContactNumber(int contactId, String contactNo, List<Contact> contacts){
		for(int i=0;i<contacts.size();i++) {
			if(contacts.get(i).getContactID()==contactId) {
				contacts.get(i).getContactNumber().add(contactNo);
				break;
			}
		}
	}
	
	// 6
	public void sortContactsByName(List<Contact> contacts) {
		Comparator<Contact> cm1=Comparator.comparing(Contact::getContactName);  
		Collections.sort(contacts,cm1);  
	}
	
	// 7
	public void readContactsFromFile(List<Contact> contacts, String fileNAme) {
		File maindir = new File("C:\\Users\\pc\\Desktop\\CoreJavaWorkSpace\\Ass1_Vashishth_Singh\\src\\assignment10\\vashishth\\singh\\"+fileNAme); 
		Scanner myReader=null;
		Contact contact;
		try {
			myReader = new Scanner(maindir);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(myReader.hasNext()){ 
			contact=new Contact();
			List<String> list;
			Object line = myReader.nextLine();
			String str[]=line.toString().split(",");
			list=new ArrayList<String>();
			for(int i=0;i<str.length;i++) {
				if(i==0) {
					try {
						contact.setContactID(Integer.parseInt(str[i]));
					}catch(NumberFormatException nfe) {
						nfe.printStackTrace();
					}
				}else if(i==1) {
					contact.setContactName(str[i]);
				}else if(i==2) {
					contact.setEmailAddress(str[i]);
				}else {
					list.add(str[i]);
				}
			}
			contact.setContactNumber(list);
			contacts.add(contact);
			//System.out.println(line);
		}
	}
	
	// 8 serializeObjectData.txt
	public void serializeContactDetails(List<Contact> contacts , String filename) {
		try {
			File maindir = new File("C:\\Users\\pc\\Desktop\\CoreJavaWorkSpace\\Ass1_Vashishth_Singh\\src\\assignment10\\vashishth\\singh\\"+filename); 
            FileOutputStream f = new FileOutputStream(maindir);
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            for(Contact contact: contacts) {
            	o.writeObject(contact);
            }
            o.close();
            f.close();

//            FileInputStream fi = new FileInputStream(maindir);
//            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            
//            Contact cont1 = (Contact) oi.readObject();
//            Contact cont2 = (Contact) oi.readObject();
//            System.out.println(cont1);
//            System.out.println(cont2);
//            oi.close();
//            fi.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } 
//		catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
	}
	
	// 9
	public List<Contact> deserializeContact(String filename){
		List<Contact> list=new ArrayList<Contact>();
		try {
			File maindir = new File("C:\\Users\\pc\\Desktop\\CoreJavaWorkSpace\\Ass1_Vashishth_Singh\\src\\assignment10\\vashishth\\singh\\"+filename); 
//            FileOutputStream f = new FileOutputStream(maindir);
//            ObjectOutputStream o = new ObjectOutputStream(f);
//
//            // Write objects to file
//            for(Contact contact: contacts) {
//            	o.writeObject(contact);
//            }
//            o.close();
//            f.close();

            FileInputStream fi = new FileInputStream(maindir);
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            
            Contact cont1 = (Contact) oi.readObject();
            Contact cont2 = (Contact) oi.readObject();
            oi.close();
            fi.close();
            list.add(cont1);
            list.add(cont2);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } 
		catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		return(list);
	}
	
	// 10
	public	Set<Contact> populateContactFromDb(){
		Set<Contact> contacts=new HashSet<Contact>();
		Contact contact;
		List<String> list;
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/contactdb","root","password");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from contact_tbl");  
			
			while(rs.next()) { 
				contact=new Contact();
				list=new ArrayList<String>();
				
				contact.setContactID(rs.getInt(1));
				contact.setContactName(rs.getString(2));
				contact.setEmailAddress(rs.getString(3));
				
				if(rs.getString(4)!=null) {
					String str[]=rs.getString(4).split(",");
					for(String s:str) {
						list.add(s);
					}
				}
				contact.setContactNumber(list);
				
				contacts.add(contact);
			}
			con.close();
			stmt.close();
			rs.close();
		}catch(Exception e){ 
			 e.printStackTrace();
		} 
		return contacts;
	}
	
	// 11
	boolean addContacts(List<Contact> existingContact,Set<Contact> newContacts) {
		boolean bool=true;
		try {
			for(Contact contact:newContacts) {
				existingContact.add(contact);
			}
		}catch(Exception e) {
			e.printStackTrace();
			bool=false;
		}
		return bool;
	}
	public static void main(String[] args) {
		List<Contact> contacts=new ArrayList<Contact>();
		ContactService contactService=new ContactService();
		Scanner sc=new Scanner(System.in);
		
		// 1
		Contact contact=new Contact();
		contact.setContactID(1);
		contact.setContactName("Vashishth Singh");
		contact.setEmailAddress("singhmuni@gmail.com");
		List<String> contactNumber=new ArrayList<String>();
		contactNumber.add("7985714663");
		contactNumber.add("9044714663");
		contactNumber.add("9147767363");
		contactNumber.add("8977448730");
		contact.setContactNumber(contactNumber);
		
		contactService.addContact(contact,contacts);
		System.out.println("QUESTION 1 :: "+contacts);
		
		// 2
		Contact contact2=new Contact();
		contact2.setContactID(2);
		contact2.setContactName("Muni Singh");
		contact2.setEmailAddress("singhmuni123@gmail.com");
		List<String> contactNumber2=new ArrayList<String>();
		contactNumber2.add("7985714678");
		contactNumber2.add("9844714663");
		contactNumber2.add("9155767363");
		contactNumber2.add("8977466630");
		contact2.setContactNumber(contactNumber2);
		
		try {
			contactService.removeContact(contact2, contacts);
		} catch (ContactNotFoundException e) {
			e.printStackTrace();
		}
		//contactService.addContact(contact2,contacts);
		System.out.println("QUESTION 2 :: "+contacts);
		
		// 3
		try {
			System.out.println("Enter The Name: ");
			String name=sc.nextLine();
			System.out.println("QUESTION 3 :: Found "+contactService.searchContactByName(name, contacts));
		} catch (ContactNotFoundException e) {
			e.printStackTrace();
		}
		
		// 4
		try {
			System.out.println(contactService.SearchContactByNumber("4666", contacts));
		} catch (ContactNotFoundException e) {
			e.printStackTrace();
		}
		
		// 5
		contactService.addContactNumber(2,"5555555555",contacts);
		System.out.println(contacts);
		
		// 6
		contactService.sortContactsByName(contacts);
		System.out.println(contacts);
		
		// 7
		System.out.println("Enter The File Name:");
		contactService.readContactsFromFile(contacts,sc.nextLine());
		System.out.println(contacts);
		
		// 8
		contactService.serializeContactDetails(contacts,"serializeObjectData.txt");
		
		// 9
		System.out.println(contactService.deserializeContact("serializeObjectData.txt"));
		
		// 10
		Set<Contact> contactSet=new HashSet<Contact>();
		contactSet=contactService.populateContactFromDb();
		System.out.println(contactSet);
		
		// 11
		System.out.println(contactService.addContacts(contacts,contactSet));
		System.out.println(contacts);
	}
}
