package lathin;

import java.util.ArrayList;
import java.util.Scanner;

public class Lathin {

	Scanner scan = new Scanner(System.in);
	ArrayList<String> arrkingdom = new ArrayList<>();
	ArrayList<String> arrtype = new ArrayList<>();
	ArrayList<String> arrgrade = new ArrayList<>();
	ArrayList<String> arrid = new ArrayList<>();

	int menu;
	String kingdom, type, grade, id;
	public Lathin() {
		
			do {
				System.out.println("Harvest Sun");
				System.out.println("===========");
				System.out.println("1. Breed");
				System.out.println("2. Sell");
				System.out.println("3. Exit");
				System.out.print("Choose: ");
				try {
					menu = scan.nextInt();
				} catch (Exception e) {
					menu = 0;
				}
				scan.nextLine();

				if (menu == 1) {
					if(arrkingdom.isEmpty()) {
						do {
							System.out.print("Select kingdom [Animalia | Plantae]: ");
							kingdom = scan.nextLine();
						} while (!kingdom.equals("Animalia") && !kingdom.equals("Plantae"));
						
						if (kingdom.equals("Animalia")) {
							do {
								System.out.print("Select type [Chicken | Cow | Sheep]: ");
								type = scan.nextLine();
							} while (!type.equals("Chicken") && !type.equals("Cow") && !type.equals("Sheep"));
						} else if (kingdom.equals("Plantae")) {
							do {
								System.out.print("Select type [Parnship | Potato | Pumpkin]: ");
								type = scan.nextLine();
							} while (!type.equals("Parnship") && !type.equals("Potato") && !type.equals("Pumpkin"));
						}
						do {
							System.out.print("Select grade [Silver | Gold | Platinum]: ");
							grade = scan.nextLine();
						} while (!grade.equalsIgnoreCase("Silver") && !grade.equalsIgnoreCase("Gold")
								&& !grade.equalsIgnoreCase("Platinum"));
						
						String idx = "";
						idx += type.toUpperCase().charAt(0);
						idx += type.toUpperCase().charAt(1);
						boolean checkID = true;
						
						do {
							System.out.print("Input ID ["+idx+"-XXX]: ");
							id = scan.nextLine();
							for(int i=3; i<id.length(); i++) {
								if(id.charAt(i) < '0' || id.charAt(i) > '9') {
									checkID = false;
								}
							}
						}while(!checkID || id.length() !=6 || 	!id.startsWith(idx+"-"));
						
						arrkingdom.add(kingdom);
						arrtype.add(type);
						arrgrade.add(grade);
						arrid.add(id);
						
						System.out.println("Success breed!");
						System.out.println("Press enter to continue");
						System.out.println();
						scan.nextLine();
					} else {
						System.out.println("Already bred animal/ plant. Sell it first!");
						System.out.println("Press enter to continue.");
						scan.nextLine();
						continue;
					}
				}
				
				else if (menu == 2) {
					if (arrkingdom.isEmpty()) {
						System.out.println("No bred animal/ plant found");
						System.out.println("Press enter to continue");
						scan.nextLine();
						continue;
					} 
					int totalprice = 0;
					
					if (grade.equalsIgnoreCase("Silver")) {
						totalprice = 0 + (type.length() * 1304000);
					} else if (grade.equalsIgnoreCase("Gold")) {
						totalprice = 150000 + (type.length() * 1304000);
					} else if (grade.equalsIgnoreCase("Platinum")) {
						totalprice = 200000 + (type.length() * 1304000);
					}
					
						for (int i = 0; i < arrkingdom.size(); i++) {
							System.out.println("Information:");
							System.out.println("==============");
							System.out.println("Kingdom: " + arrkingdom.get(i));
							System.out.println("Type: " + arrtype.get(i));
							System.out.println("Grade: " + arrgrade.get(i));
							System.out.println("ID: " + arrid.get(i));
							System.out.println("==============");
							System.out.println();
							System.out.println("Total price: " + totalprice);
							System.out.println("Success sell bred animal/ plant!");
							System.out.println("Press enter to continue.");
							scan.nextLine();
						
					}
				}

			} while (menu != 3);

		}

	public static void main(String[] args) {
		new Lathin();
	}

}
