package com.jdbc.main;

import java.sql.SQLException;

import java.util.Scanner;

import com.jdbc.filed.BankFields;
import com.jdbc.method.ExecuteMethod;

@SuppressWarnings("unused")
public class Main {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ExecuteMethod executeMethod = new ExecuteMethod();
			Scanner scanner1 = new Scanner(System.in);
			try (Scanner scanner = new Scanner(System.in);) {

				boolean isRunning = true;
				boolean isStop = true;

				while (isStop) {

					System.out.print("\n     ( Admin or Client) :-  ");
					String str1 = scanner.next();

					if (str1.equals("Admin")) {

						while (isRunning) {
							System.out.println("\n         [_____1.OPEN ACCOUNT_____]");
							System.out.println("         [_____2.VIEW PROFILES_____]");
							System.out.println("         [_____3.CLOSE AN ACCOUNT  _____]");
							System.out.println("         [_____4.VIEW BY ACC_NO  _____]");
							System.out.println("         [_____5.EDIT AN ACC_DETAILS  _____]");
							System.out.println("         [_____6.STATEMENTS  _____]");
							System.out.println("         [_____7.EXIT  _____]");

							System.out.print("\n          Enter your choice :- ");

							int choice = scanner.nextInt();

							switch (choice) {
							case 1:

								System.out.println("Enter your name(with capital letters ) : ");
								String name = scanner1.nextLine();
								System.out.println("Enter your Date of birth  : ");
								System.out.println(" Year  ");
								int  dob = scanner1.nextInt();
								System.out.println("Enter Your Address : ");
								String address = scanner1.next();
								System.out.println("   ");
								
								
								System.out.println("Enter your Phone Number :-");
								long ph = scanner.nextLong();
								System.out.println("Enter Amount to opening balance : ");
								int money = scanner1.nextInt();
								
								
								executeMethod.openAccount(new BankFields(name,dob,address,ph,money,null));


								break;

							case 2:
								
								executeMethod.viewAllProfile();
								
								break;

							case 3:

								System.out.print("\n     Enter The Account Number :- ");
								int acc = scanner.nextInt();
								
								executeMethod.deleteAcc(acc);

								break;

							case 4:

								System.out.print("\n      Enter The Account Number  :- ");
								int  acc1 = scanner.nextInt();
								executeMethod.viewByAccNo(acc1);
								break;

							case 5:

								System.out.println("\n     Enter The Account Number :- ");
								int acc2 = scanner.nextInt();
								executeMethod.editAccount(acc2);

								break;

							case 6:
								
								break;
							
							case 7 :
								System.out.println("\n*****[---Thak you. Visit Again.---]*****");
								isRunning = false;

								break;
								
							default:

								System.out.println("\n     .....Incorrect choice..... ");
								break;
							}

						}
					} else if (str1.equals("Client")) {

						System.out.println("\n     WELCOME TO BSB  ");

						System.out.println("\n\n     Enter You Accoount number :");
						int ACC = scanner.nextInt();
						boolean b = true;

						while (b) {

							System.out.println("\n     [_____1.View Your Details     _____]");
							System.out.println("     [_____2.Complaint about your data_____]");
							System.out.println("     [_____3.Wirthdrawn     _____]");
							System.out.println("     [_____4.Deposit     _____]");
							System.out.println("     [_____5.Mini Statements     _____]");

							System.out.println("     Enter Your Choice : ");
							int choice = scanner.nextInt();

							switch (choice) {

							case 1:

							
								executeMethod.viewByAccNo(ACC);

								break;

							case 2:

								System.out.println("Enter your complaint ");
								String com=scanner.next();
								executeMethod.complaint(new BankFields(ACC,com));


								break;

							case 3:
								
								System.out.println("Enter Amount To Withdrawn ");
								int amount = scanner.nextInt();
								executeMethod.withdrawn(new BankFields(ACC,amount));

								break;

							default:

								System.out.println("\n......Invalid choice.....");

								break;
							}
						}
					} else {

						System.out.println("\n......Invalid Name.....");
					}
				}
			} catch (Exception e) {

				throw new RuntimeException("\n ...Something went wrong... " + e);
				// e.printStackTrace();
			}
		

	}

}
